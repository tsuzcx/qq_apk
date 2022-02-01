package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimeAdpater;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.InputMethodChangeListener;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper;
import com.tencent.mobileqq.troop.homework.logic.IHomeworkHelper;
import com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper;
import com.tencent.mobileqq.troop.homework.observer.HomeworkObserver;
import com.tencent.mobileqq.troop.homework.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishHomeWorkFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, InputMethodGuard.InputMethodChangeListener
{
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  protected SparseArrayCompat<IHomeworkHelper> a;
  protected ViewGroup a;
  protected EditText a;
  protected AppInterface a;
  protected CommonRecordSoundPanel a;
  protected HomeworkInfo a;
  protected PublishHomeWorkFragment.UIHandler a;
  protected HwkTimePicker a;
  protected InputMethodGuard a;
  protected HomeworkHandler a;
  protected HomeworkObserver a;
  protected XMediaEditor a;
  protected FormSwitchItem a;
  protected QFormSimpleItem a;
  protected QQProgressDialog a;
  protected ActionSheet a;
  protected Boolean a;
  protected String a;
  protected ArrayList<String> a;
  protected List<Pair<Integer, View>> a;
  protected boolean a;
  protected int b;
  protected long b;
  protected ViewGroup b;
  protected HomeworkInfo b;
  protected QFormSimpleItem b;
  protected String b;
  protected List<String> b;
  protected long c;
  protected View c;
  protected ViewGroup c;
  protected String c;
  protected boolean c;
  protected View d;
  protected ViewGroup d;
  protected String d;
  protected boolean d;
  protected View e;
  protected ViewGroup e;
  protected String e;
  protected boolean e;
  protected String f;
  protected boolean f;
  protected boolean g = false;
  protected boolean h;
  protected boolean i = false;
  protected boolean j = false;
  protected boolean k = false;
  protected boolean l = false;
  protected boolean m = false;
  protected boolean n = false;
  
  public PublishHomeWorkFragment()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = null;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PublishHomeWorkFragment.19(this);
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i1))).a(paramInt1, paramInt2, paramIntent);
      i1 += 1;
    }
  }
  
  private void a(int paramInt, IHomeworkHelper paramIHomeworkHelper)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramIHomeworkHelper);
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putString("PublishHomeWorkFragment:valid", "PublishHomeWorkFragment:valid");
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("extra.GROUP_UIN", paramString);
    }
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.start(paramActivity, localIntent, PublishHomeWorkFragment.class);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i1))).a(paramJSONArray);
      i1 += 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i1))).a(paramJSONObject);
      i1 += 1;
    }
  }
  
  private boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker != null)
    {
      if (paramLong < l1 + 1L)
      {
        QQToast.a(getActivity(), 2131697481, 0).a();
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i1))).a(paramInt);
      i1 += 1;
    }
  }
  
  private void c(HomeworkInfo paramHomeworkInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(paramHomeworkInfo.d));
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("title", paramHomeworkInfo.jdField_a_of_type_JavaLangString);
    if (paramHomeworkInfo.jdField_a_of_type_Boolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localBundle.putString("need_feedback", str1);
    localBundle.putString("c", paramHomeworkInfo.jdField_b_of_type_JavaLangString);
    String str2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
    paramHomeworkInfo = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    String str1 = null;
    if (paramHomeworkInfo != null)
    {
      str1 = paramHomeworkInfo.getSkey(str2);
      paramHomeworkInfo = paramHomeworkInfo.getPskey(str2, "qun.qq.com");
    }
    else
    {
      paramHomeworkInfo = null;
    }
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getBknBySkey(str1));
    localBundle.putString("bkn", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append(str2);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str1);
    localStringBuilder.append(";p_uin=o");
    localStringBuilder.append(str2);
    localStringBuilder.append(";p_skey=");
    localStringBuilder.append(paramHomeworkInfo);
    localBundle.putString("Cookie", localStringBuilder.toString());
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new PublishHomeWorkFragment.20(this), 1000, null).a(localHashMap);
  }
  
  private void d(HomeworkInfo paramHomeworkInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("course_id", "0");
    if (!this.jdField_a_of_type_JavaLangString.isEmpty()) {
      localBundle.putString("course_name", this.jdField_a_of_type_JavaLangString);
    } else {
      localBundle.putString("course_name", HardCodeUtil.a(2131697438));
    }
    localBundle.putString("title", paramHomeworkInfo.jdField_a_of_type_JavaLangString);
    if (paramHomeworkInfo.jdField_a_of_type_Boolean) {
      str = "1";
    } else {
      str = "0";
    }
    localBundle.putString("need_feedback", str);
    localBundle.putString("c", paramHomeworkInfo.jdField_b_of_type_JavaLangString);
    localBundle.putString("team_id", "0");
    localBundle.putString("hw_type", "0");
    localBundle.putString("tsfeedback", String.valueOf(this.jdField_c_of_type_Long));
    if ((paramHomeworkInfo.jdField_a_of_type_JavaUtilList != null) && (paramHomeworkInfo.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i1 = 0;
      str = "[";
      while (i1 < paramHomeworkInfo.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(String.valueOf(paramHomeworkInfo.jdField_a_of_type_JavaUtilList.get(i1)));
        ((StringBuilder)localObject).append(",");
        str = ((StringBuilder)localObject).toString();
        i1 += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(String.valueOf(paramHomeworkInfo.jdField_a_of_type_JavaUtilList.get(i1)));
      ((StringBuilder)localObject).append("]");
      localBundle.putString("syncgids", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
    paramHomeworkInfo = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    String str = null;
    if (paramHomeworkInfo != null)
    {
      str = paramHomeworkInfo.getSkey((String)localObject);
      paramHomeworkInfo = paramHomeworkInfo.getPskey((String)localObject, "qun.qq.com");
    }
    else
    {
      paramHomeworkInfo = null;
    }
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getBknBySkey(str));
    localBundle.putString("bkn", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str);
    localStringBuilder.append(";p_uin=o");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(";p_skey=");
    localStringBuilder.append(paramHomeworkInfo);
    localBundle.putString("Cookie", localStringBuilder.toString());
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new PublishHomeWorkFragment.21(this), 1000, null).a(localHashMap);
  }
  
  private void d(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i1))).b(paramBoolean);
      i1 += 1;
    }
  }
  
  private void q()
  {
    a(2, new DocsEntranceHelper(this, this.jdField_b_of_type_JavaLangString));
    a(1, new WeiKeEntranceHelper(this, this.jdField_b_of_type_JavaLangString));
  }
  
  private void r()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i1))).a();
      i1 += 1;
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker = HwkTimeAdpater.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a(new PublishHomeWorkFragment.12(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a(new PublishHomeWorkFragment.13(this));
  }
  
  protected int a()
  {
    return 2131560664;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localBundle.putString("reportIdentity", str1);
    if (this.k)
    {
      str2 = this.jdField_e_of_type_JavaLangString;
      str1 = str2;
      if (str2 != null) {
        break label65;
      }
    }
    else
    {
      str2 = this.jdField_f_of_type_JavaLangString;
      str1 = str2;
      if (str2 != null) {
        break label65;
      }
    }
    str1 = "";
    label65:
    localBundle.putString("reportCourse", str1);
    return localBundle;
  }
  
  public <T extends View> T a(int paramInt)
  {
    return this.jdField_b_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  protected EditText a(View paramView)
  {
    EditText localEditText = null;
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = localViewGroup.getChildCount();
      int i1 = 0;
      paramView = localEditText;
      while (i1 < i2)
      {
        localEditText = a(localViewGroup.getChildAt(i1));
        if (localEditText != null) {
          paramView = localEditText;
        }
        i1 += 1;
      }
      return paramView;
    }
    if (((paramView instanceof EditText)) && (paramView.isFocused())) {
      return (EditText)paramView;
    }
    return null;
  }
  
  public XMediaEditor a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
  }
  
  public String a(long paramLong)
  {
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTimeInMillis(paramLong * 1000L);
    ((Calendar)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    int i1 = ((Calendar)localObject3).get(1);
    int i2 = ((Calendar)localObject3).get(2);
    int i3 = ((Calendar)localObject3).get(5);
    ((Calendar)localObject3).get(7);
    Object localObject2 = String.valueOf(((Calendar)localObject3).get(11));
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject3 = String.valueOf(((Calendar)localObject3).get(12));
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (((String)localObject3).length() == 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0");
        ((StringBuilder)localObject2).append((String)localObject3);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(String.valueOf(i1));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131697483));
    ((StringBuilder)localObject3).append(String.valueOf(i2 + 1));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131697482));
    ((StringBuilder)localObject3).append(String.valueOf(i3));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131697480));
    ((StringBuilder)localObject3).append(" ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
  
  @NonNull
  protected List<String> a(UploadEditItemInfo paramUploadEditItemInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramUploadEditItemInfo != null)
    {
      if ((paramUploadEditItemInfo instanceof VideoInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131708834));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof ImageInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131708817));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof AudioInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131708823));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
      }
    }
    return localArrayList;
  }
  
  List<Pair<Integer, View>> a(String paramString)
  {
    return new ArrayList();
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler = new PublishHomeWorkFragment.UIHandler(this, Looper.getMainLooper());
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if (getActivity() == null) {
      localObject = null;
    } else {
      localObject = (AppInterface)getQBaseActivity().getAppRuntime();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject);
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject == null)
    {
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler = ((HomeworkHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName()));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver = new PublishHomeWorkFragment.2(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver);
    if (!this.m)
    {
      this.m = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt)).a();
    int i1 = 0;
    Object localObject;
    if ((bool) && (paramInt == 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_c_of_type_Long == 0L)
          {
            localObject = (HwkTimeAdpater)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a();
            this.jdField_c_of_type_Long = HwkTimeAdpater.a();
            this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText(a(this.jdField_c_of_type_Long));
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setClickable(true);
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_c_of_type_Long != 0L) {
            this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText(a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_c_of_type_Long));
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setClickable(false);
        }
      }
    }
    else
    {
      this.jdField_c_of_type_Long = 0L;
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText("");
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
    }
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      ((IHomeworkHelper)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i1))).a(paramInt, bool);
      i1 += 1;
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = localArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditItemInfoBase)((Iterator)localObject1).next();
      if (localObject2 != null) {
        localJSONArray.put(((EditItemInfoBase)localObject2).a());
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject1, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_d_of_type_JavaLangString = "";
      this.k = false;
      break;
    case 335: 
      this.jdField_d_of_type_JavaLangString = "student";
      this.k = false;
      break;
    case 334: 
      this.jdField_d_of_type_JavaLangString = "parent";
      this.k = false;
      break;
    case 333: 
      this.jdField_d_of_type_JavaLangString = "teacher";
      this.k = true;
      break;
    case 332: 
      this.jdField_d_of_type_JavaLangString = "classteacher";
      this.k = true;
    }
    this.jdField_e_of_type_JavaLangString = paramString1;
    this.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = this.jdField_b_of_type_JavaLangString;
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str1;
    if (this.k)
    {
      str1 = this.jdField_e_of_type_JavaLangString;
      paramString1 = str1;
      if (str1 != null) {
        break label174;
      }
    }
    else
    {
      str1 = this.jdField_f_of_type_JavaLangString;
      paramString1 = str1;
      if (str1 != null) {
        break label174;
      }
    }
    paramString1 = "";
    label174:
    if (this.jdField_a_of_type_Int == 1) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    TroopReportor.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str2, paramString1, str1 });
  }
  
  protected void a(int paramInt, ArrayList<UploadEditItemInfo> paramArrayList, HomeworkInfo paramHomeworkInfo)
  {
    if (paramInt == 0)
    {
      paramHomeworkInfo = new ArrayList();
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramHomeworkInfo.addAll(a((UploadEditItemInfo)((Iterator)localObject).next()));
      }
      paramHomeworkInfo = new ArrayList(new TreeSet(paramHomeworkInfo));
      if (paramHomeworkInfo.isEmpty())
      {
        paramHomeworkInfo = "";
      }
      else if (paramHomeworkInfo.size() == 1)
      {
        paramHomeworkInfo = (String)paramHomeworkInfo.get(0);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramHomeworkInfo.get(0));
        ((StringBuilder)localObject).append("、");
        ((StringBuilder)localObject).append((String)paramHomeworkInfo.get(1));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131708815));
        paramHomeworkInfo = ((StringBuilder)localObject).toString();
      }
      int i1 = this.jdField_b_of_type_Int;
      if (i1 == 0)
      {
        this.jdField_b_of_type_Int = (i1 + 1);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131697500, new Object[] { paramHomeworkInfo });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
      else
      {
        paramArrayList = getString(2131697498, new Object[] { paramHomeworkInfo });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
    }
    else if (paramInt == 1)
    {
      QQToast.a(getActivity(), 2131697469, 0).a();
    }
    else if (paramInt == 3)
    {
      QQToast.a(getActivity(), 2131697494, 0).a();
    }
    else if (paramInt == 2)
    {
      QQToast.a(getActivity(), 2131694431, 0).a();
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("Error, reason_code = ");
      paramArrayList.append(paramInt);
      paramArrayList.append(", print trace: ");
      QLog.d("PublishHomeWorkFragment", 2, paramArrayList.toString(), new RuntimeException("UPLOAD_ERROR"));
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    a();
    e();
    q();
    d();
    f();
    if (MobileQQ.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  protected void a(HomeworkInfo paramHomeworkInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = paramHomeworkInfo;
    paramHomeworkInfo = paramHomeworkInfo.jdField_b_of_type_JavaLangString;
    for (;;)
    {
      int i1;
      try
      {
        paramHomeworkInfo = new JSONObject(paramHomeworkInfo).getJSONArray("c");
        i1 = 0;
        if (i1 < paramHomeworkInfo.length())
        {
          JSONObject localJSONObject = paramHomeworkInfo.getJSONObject(i1);
          if (localJSONObject != null) {
            a(localJSONObject);
          }
        }
        else
        {
          a(new JSONObject().put("c", paramHomeworkInfo).toString());
          if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().isEmpty()))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          }
          return;
        }
      }
      catch (Exception paramHomeworkInfo)
      {
        return;
      }
      i1 += 1;
    }
  }
  
  protected void a(Pair<Integer, View> paramPair)
  {
    if (this.jdField_d_of_type_AndroidViewViewGroup != null)
    {
      if (paramPair == null) {
        return;
      }
      int i1 = ((Integer)paramPair.first).intValue();
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        this.jdField_c_of_type_AndroidViewViewGroup.addView((View)paramPair.second, 0);
        return;
      }
      this.jdField_d_of_type_AndroidViewViewGroup.addView((View)paramPair.second);
    }
  }
  
  protected void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("c"))
      {
        paramString = paramString.getJSONArray("c");
        if (paramString != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setDataByEdit(paramString);
          ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.4(this), 550L);
        }
      }
      else
      {
        paramString = new IllegalArgumentException("home work json format error");
        if (QLog.isColorLevel())
        {
          QLog.e("PublishHomeWorkFragment", 2, paramString, new Object[0]);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "parse homework json error", paramString);
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        if (("recite".equals(new JSONObject(paramString).getString("type"))) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublishHomeWorkFragment", 2, "onSpecialHomeWorkChanged error ", paramString);
        }
      }
    }
  }
  
  protected void a(@NonNull ArrayList<UploadEditItemInfo> paramArrayList)
  {
    Object localObject = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((List)localObject).addAll(a((UploadEditItemInfo)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet((Collection)localObject));
    if (paramArrayList.isEmpty())
    {
      paramArrayList = "";
    }
    else if (paramArrayList.size() == 1)
    {
      paramArrayList = (String)paramArrayList.get(0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)paramArrayList.get(0));
      ((StringBuilder)localObject).append("、");
      ((StringBuilder)localObject).append((String)paramArrayList.get(1));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708826));
      paramArrayList = ((StringBuilder)localObject).toString();
    }
    paramArrayList = getString(2131697500, new Object[] { paramArrayList });
    QQToast.a(getActivity(), paramArrayList, 0).a();
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      k();
      return;
    }
    if (paramInt == 10022)
    {
      a(1, null, null);
      return;
    }
    if (paramInt == 1002)
    {
      a(2, null, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UPLOAD_ERROR_UNKNOWN_ERROR: server error ");
      localStringBuilder.append(paramInt);
      QLog.e("PublishHomeWorkFragment", 2, localStringBuilder.toString());
    }
    a(3, null, null);
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    String str = paramJSONObject.optString("type");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return (!"str".equals(str)) || (!TextUtils.isEmpty(paramJSONObject.optString("text")));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void b(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2);
    if (i2 >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131708816));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131708820));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && ((getActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      getQBaseActivity().requestPermissions(new PublishHomeWorkFragment.10(this, i2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - i2, getActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivityForResult(paramView, 259);
    InputMethodUtil.a(getActivity());
  }
  
  protected void b(HomeworkInfo paramHomeworkInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        UploadEditItemInfo localUploadEditItemInfo = (UploadEditItemInfo)((Iterator)localObject).next();
        if (localUploadEditItemInfo != null) {
          if (localUploadEditItemInfo.c() == 1) {
            localArrayList1.add(localUploadEditItemInfo);
          } else if ((localUploadEditItemInfo.c() == 2) || (localUploadEditItemInfo.c() == 0)) {
            localArrayList2.add(localUploadEditItemInfo);
          }
        }
      }
      if (!localArrayList1.isEmpty())
      {
        a(localArrayList1);
        return;
      }
      if (!localArrayList2.isEmpty())
      {
        a(0, localArrayList2, paramHomeworkInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, paramHomeworkInfo);
      return;
    }
    if (paramHomeworkInfo != null)
    {
      b(2131697479);
      int i1 = this.jdField_a_of_type_Int;
      if (i1 == 1)
      {
        d(paramHomeworkInfo);
        return;
      }
      if (i1 == 2) {
        c(paramHomeworkInfo);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
      }
      a(3, null, paramHomeworkInfo);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.17(this), 10L);
    c(paramBoolean);
    View localView = this.jdField_e_of_type_AndroidViewView;
    if (paramBoolean) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    localView.setVisibility(paramInt);
    if (HomeWorkConstants.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  boolean b()
  {
    try
    {
      Object localObject = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      int i1 = ((JSONArray)localObject).length();
      if (i1 > 0)
      {
        if (i1 == 1)
        {
          localObject = ((JSONArray)localObject).getJSONObject(0);
          if (localObject != null)
          {
            String str = ((JSONObject)localObject).getString("type");
            if (TextUtils.isEmpty(str)) {
              break label96;
            }
            if ("str".equals(str))
            {
              boolean bool = TextUtils.isEmpty(((JSONObject)localObject).getString("text"));
              if (bool) {
                break label96;
              }
            }
          }
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    label96:
    return true;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("检测到你是");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("老师，将按照需求定制入口");
        QLog.d("PublishHomeWorkFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      }
    }
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131708812));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131708829));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.CAMERA") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      getQBaseActivity().requestPermissions(new PublishHomeWorkFragment.11(this), 3, new String[] { "android.permission.CAMERA" });
      return;
    }
    this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
    InputMethodUtil.a(getActivity());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView = this.jdField_d_of_type_AndroidViewView;
      int i1;
      if (this.jdField_a_of_type_Boolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
      this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    else
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.18(this), 20L);
    }
    d(paramBoolean);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = a(2131373258);
    this.jdField_e_of_type_AndroidViewView = a(2131379232);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368896));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560663, null, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373247));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131373257));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_d_of_type_AndroidViewView = a(2131363773);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377760));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377759));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377758));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365023));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)a(2131373253));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)a(2131373259));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131373254));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new PublishHomeWorkFragment.3(this));
    r();
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
    Object localObject = a(2131373255);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = a(2131373262);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = a(2131373263);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker == null) {}
    try
    {
      s();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a() instanceof HwkTimeAdpater))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker;
        HwkTimeAdpater.a((HwkTimePicker)localObject, (HwkTimeAdpater)((HwkTimePicker)localObject).a());
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131708814));
        localStringBuilder.append(6);
        localStringBuilder.append(HardCodeUtil.a(2131708821));
        QQToast.a(paramView, localStringBuilder.toString(), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    m();
  }
  
  protected void e()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("extra.GROUP_UIN");
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("publish_homework_mode", 1);
      this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("hw_id", 0L);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_JavaLangString = str;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uin: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("PublishHomeWorkFragment", 2, ((StringBuilder)localObject).toString());
        }
        g();
        a(8000L);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Long > 0L)
          {
            b(2131697478);
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHandlerHomeworkHandler.a(this.jdField_a_of_type_Long);
            return;
          }
          QQToast.a(getActivity(), 2131697496, 0).a();
          getActivity().finish();
        }
      }
      else
      {
        QQToast.a(getActivity(), 2131697496, 0).a();
        getActivity().finish();
      }
    }
    else
    {
      QQToast.a(getActivity(), 2131697496, 0).a();
      getActivity().finish();
    }
  }
  
  protected void e(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker == null) {}
    try
    {
      s();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a() instanceof HwkTimeAdpater))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker;
        HwkTimeAdpater.a(paramView, (HwkTimeAdpater)paramView.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  protected void f()
  {
    a(2131697461, new PublishHomeWorkFragment.5(this));
    c(2131697475, new PublishHomeWorkFragment.6(this));
    int i1 = this.jdField_a_of_type_Int;
    if (i1 == 1) {
      a(getResources().getString(2131697477));
    } else if (i1 == 2) {
      a(getResources().getString(2131697453));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new PublishHomeWorkFragment.7(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new PublishHomeWorkFragment.8(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131697470));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 1) {
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    g();
  }
  
  public void g()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.sendMessage(localMessage);
  }
  
  protected void h()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
    int i1 = 1;
    Object localObject;
    if (!bool)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Integer)((Pair)((Iterator)localObject).next()).first).intValue() == 1) {
          break label62;
        }
      }
    }
    i1 = 0;
    label62:
    if (i1 != 0)
    {
      c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
      if ((this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) || (this.jdField_b_of_type_AndroidViewViewGroup.getHeight() <= 0))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 514;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.sendMessageDelayed((Message)localObject, 100L);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  protected void i()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          a((Pair)((Iterator)localObject).next());
        }
        this.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  protected void j()
  {
    Object localObject3 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
    JSONArray localJSONArray = new JSONArray();
    int i2 = ((JSONArray)localObject3).length();
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = this.jdField_d_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 1) {
      localObject2 = "1";
    } else {
      localObject2 = "2";
    }
    TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
    int i1 = 0;
    while (i1 < i2)
    {
      localObject1 = ((JSONArray)localObject3).optJSONObject(i1);
      if (a((JSONObject)localObject1)) {
        localJSONArray.put(localObject1);
      }
      i1 += 1;
    }
    if (localJSONArray.length() <= 0)
    {
      QQToast.a(getActivity(), 2131697464, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    localObject1 = new HomeworkInfo();
    ((HomeworkInfo)localObject1).jdField_b_of_type_Long = 0L;
    ((HomeworkInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((HomeworkInfo)localObject1).jdField_a_of_type_JavaLangString.trim()))
    {
      QQToast.a(getActivity(), 2131697465, 0).a();
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131694422, 0).a();
      return;
    }
    try
    {
      ((HomeworkInfo)localObject1).jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        ((HomeworkInfo)localObject1).jdField_a_of_type_Long = 0L;
      } else {
        ((HomeworkInfo)localObject1).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      }
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject2).add(Long.valueOf(Long.parseLong((String)((Iterator)localObject3).next())));
      }
      ((HomeworkInfo)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.jdField_f_of_type_Boolean) {
      localJSONArray.put(new JSONObject("{\"type\":\"calculation\"}"));
    }
    a(localJSONArray);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("c", localJSONArray);
    ((HomeworkInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_e_of_type_Boolean;
    ((HomeworkInfo)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.toString();
    if (this.jdField_a_of_type_Int == 2)
    {
      ((HomeworkInfo)localObject1).d = this.jdField_a_of_type_Long;
      ((HomeworkInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_Boolean;
    }
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = ((HomeworkInfo)localObject1);
    b((HomeworkInfo)localObject1);
  }
  
  protected void k()
  {
    try
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      str3 = "";
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      str4 = this.jdField_d_of_type_JavaLangString;
      if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString == null)) {
        break label438;
      }
      str1 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str3;
        String str4;
        continue;
        label438:
        String str1 = "";
        continue;
        String str2 = "0";
      }
    }
    if (this.jdField_e_of_type_Boolean)
    {
      str2 = "1";
      TroopReportor.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { localObject, str4, str1, str2 });
      if (this.l)
      {
        if (this.jdField_b_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_b_of_type_JavaLangString;
        }
        TroopReportor.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
      }
      c(1);
      if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_JavaLangString == null) {
          localObject = "";
        } else {
          localObject = this.jdField_b_of_type_JavaLangString;
        }
        TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (this.jdField_b_of_type_JavaLangString == null) {
          localObject = str3;
        } else {
          localObject = this.jdField_b_of_type_JavaLangString;
        }
        TroopReportor.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList.size()) });
      }
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      QQToast.a(getActivity(), 2131697476, 0).a();
      localObject = BaseAIOUtils.a(new Intent(), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      RouteUtils.a(getActivity(), (Intent)localObject, "/base/start/splash");
      getActivity().overridePendingTransition(2130772004, 2130772344);
      return;
    }
  }
  
  protected void l()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      HomeWorkTroopSelectorFragment.a(getActivity(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559849, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(ScreenUtil.SCREEN_HIGHT * 0.3F));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setAnimationTime(50);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getActionContentView().setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener(new PublishHomeWorkFragment.14(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOutsideDismissEnableCompat(true);
    InputMethodUtil.a(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  protected void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.postDelayed(new PublishHomeWorkFragment.15(this), 400L);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("PublishHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    Object localObject1;
    Object localObject2;
    if (paramInt1 != 258)
    {
      if (paramInt1 != 260)
      {
        if ((paramInt1 == 263) && (paramIntent != null) && (paramInt2 == 262))
        {
          localObject1 = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
          localObject2 = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
          }
          if (localObject2 != null)
          {
            this.jdField_b_of_type_JavaUtilList.clear();
            this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject2);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem != null) {
            if (this.jdField_b_of_type_JavaUtilList.isEmpty())
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText("");
            }
            else if (this.jdField_b_of_type_JavaUtilList.size() == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilList.get(0));
            }
            else if (this.jdField_b_of_type_JavaUtilList.size() > 1)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)this.jdField_b_of_type_JavaUtilList.get(0));
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708824));
              ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilList.size());
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708819));
              ((QFormSimpleItem)localObject1).setRightText(((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      else if (paramInt2 == -1)
      {
        if (!NetworkUtil.isNetSupport(getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
          }
          QQToast.a(getActivity(), 2131697226, 0).a();
          return;
        }
        BaseImageUtil.a(getActivity(), this.jdField_c_of_type_JavaLangString);
        localObject1 = new ImageInfo(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a((EditItemInfoBase)localObject1);
      }
    }
    else
    {
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        int i1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        localObject1 = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (i1 != -2147483648)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(i1, (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
            bool1 = false;
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(EditItemInfoFactory.a((String)localObject1));
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
          }
          a((String)localObject1, bool1);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("提交新作业->");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("PublishHomeWorkFragment", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "return from entry");
      }
    }
    a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (!b())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      PublishHomeWorkFragment.16 local16 = new PublishHomeWorkFragment.16(this);
      int i1 = this.jdField_a_of_type_Int;
      if (i1 == 1) {
        localQQCustomDialog.setMessage(2131697466);
      } else if (i1 == 2) {
        localQQCustomDialog.setMessage(2131697450);
      }
      localQQCustomDialog.setPositiveButton(2131697467, local16);
      localQQCustomDialog.setNegativeButton(2131697462, local16);
      localQQCustomDialog.show();
      InputMethodUtil.a(getActivity());
      return true;
    }
    InputMethodUtil.a(getActivity());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131373255) {
      b(paramView);
    } else if (i1 == 2131373262) {
      c(paramView);
    } else if (i1 == 2131373263) {
      d(paramView);
    } else if (i1 == 2131373253) {
      l();
    } else if (i1 == 2131373259) {
      e(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    HomeworkObserver localHomeworkObserver = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkObserverHomeworkObserver;
    if (localHomeworkObserver != null)
    {
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localAppInterface != null) {
        localAppInterface.removeObserver(localHomeworkObserver);
      }
    }
    HWTroopUtils.a();
    if (this.m)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.m = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130772004, 2130772344);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0) != 259) {
      return;
    }
    this.h = ImageItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.h);
  }
  
  public void onPause()
  {
    super.onPause();
    InputMethodUtil.a(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
  
  protected void p()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label23:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */