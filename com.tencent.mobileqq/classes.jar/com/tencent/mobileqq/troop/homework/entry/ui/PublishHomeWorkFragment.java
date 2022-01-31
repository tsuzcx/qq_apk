package com.tencent.mobileqq.troop.homework.entry.ui;

import ajoe;
import ajof;
import ajog;
import ajoh;
import ajoi;
import ajoj;
import ajok;
import ajol;
import ajom;
import ajon;
import ajoo;
import ajop;
import ajoq;
import ajor;
import ajos;
import ajot;
import ajou;
import ajov;
import ajow;
import ajox;
import ajoy;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.InputMethodChangeListener;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class PublishHomeWorkFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, InputMethodGuard.InputMethodChangeListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ajoy jdField_a_of_type_Ajoy;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajoo(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private CommonRecordSoundPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  private HomeworkInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo;
  private InputMethodGuard jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard;
  private XMediaEditor jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private String jdField_b_of_type_JavaLangString = "";
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  private View a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  private static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130841438);
    Object localObject = new LinearLayout.LayoutParams(-2, ScreenUtil.a(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(ScreenUtil.a(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(-16777216);
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(ScreenUtil.a(12.0F), 0, ScreenUtil.a(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(ScreenUtil.a(21.0F), ScreenUtil.a(21.0F));
      paramString.setMargins(ScreenUtil.a(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new ajox(paramInt1, paramObject));
    return localLinearLayout;
  }
  
  private static View a(Context paramContext, int paramInt, String paramString1, String paramString2, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, Object paramObject)
  {
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new FormSwitchItem(paramContext);
    ((FormSwitchItem)localObject).setText(paramString1);
    ((FormSwitchItem)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    ((FormSwitchItem)localObject).setBgType(0);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    paramContext = new TextView(paramContext);
    paramContext.setTextSize(1, 14.0F);
    paramContext.setTextColor(Color.parseColor("#BBBBBB"));
    paramContext.setPadding(ScreenUtil.a(12.0F), 0, ScreenUtil.a(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, ScreenUtil.a(2.0F), 0, ScreenUtil.a(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new ajox(paramInt, paramObject));
    return localLinearLayout;
  }
  
  private View a(Class paramClass, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return null;
      if (paramClass.isInstance(paramView)) {
        return (View)paramClass.cast(paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int n = paramView.getChildCount();
        int m = 0;
        while (m < n)
        {
          View localView = a(paramClass, paramView.getChildAt(m));
          if (localView != null) {
            return localView;
          }
          m += 1;
        }
      }
    }
  }
  
  private EditText a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView == null) {
      localObject2 = localObject1;
    }
    int n;
    int m;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      n = ((ViewGroup)paramView).getChildCount();
      m = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (m >= n);
    localObject2 = a(((ViewGroup)paramView).getChildAt(m));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      m += 1;
      break label38;
      localObject2 = localObject1;
      if (!(paramView instanceof EditText)) {
        break;
      }
      localObject2 = localObject1;
      if (!paramView.isFocused()) {
        break;
      }
      return (EditText)paramView;
    }
  }
  
  @NonNull
  private List a(UploadEditItemInfo paramUploadEditItemInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramUploadEditItemInfo != null)
    {
      if (!(paramUploadEditItemInfo instanceof VideoInfo)) {
        break label47;
      }
      localArrayList.add("视频" + "");
    }
    label47:
    do
    {
      return localArrayList;
      if ((paramUploadEditItemInfo instanceof ImageInfo))
      {
        localArrayList.add("图片" + "");
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof AudioInfo))
      {
        localArrayList.add("录音" + "");
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof ArithmeticInfo))
      {
        localArrayList.add("图片" + "");
        return localArrayList;
      }
    } while (!(paramUploadEditItemInfo instanceof HWReciteInfo));
    localArrayList.add("录音" + "");
    return localArrayList;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt == 7) {
      if (this.jdField_e_of_type_Boolean)
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label63;
        }
        localObject = "";
        TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
      }
    }
    label63:
    ArrayList localArrayList;
    JSONArray localJSONArray;
    do
    {
      return;
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt);
      localJSONArray = new JSONArray();
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)((Iterator)localObject).next();
        if (localEditItemInfoBase != null) {
          localJSONArray.put(localEditItemInfoBase.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
      return;
    }
  }
  
  private void a(int paramInt, ArrayList paramArrayList, HomeworkInfo paramHomeworkInfo)
  {
    if (paramInt == 0)
    {
      paramHomeworkInfo = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        paramHomeworkInfo.addAll(a((UploadEditItemInfo)localIterator.next()));
      }
      paramHomeworkInfo = new ArrayList(new TreeSet(paramHomeworkInfo));
      if (paramHomeworkInfo.isEmpty())
      {
        paramHomeworkInfo = "";
        if (this.jdField_a_of_type_Int != 0) {
          break label274;
        }
        this.jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131430658, new Object[] { paramHomeworkInfo });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramHomeworkInfo.size() == 1)
      {
        paramHomeworkInfo = (String)paramHomeworkInfo.get(0);
        break;
      }
      paramHomeworkInfo = (String)paramHomeworkInfo.get(0) + "、" + (String)paramHomeworkInfo.get(1) + "等内容";
      break;
      label274:
      paramArrayList = getString(2131430659, new Object[] { paramHomeworkInfo });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131430664, 0).a();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131430662, 0).a();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131433233, 0).a();
      }
    }
  }
  
  private void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_Ajoy.sendMessageDelayed(localMessage, paramLong);
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
    PublicFragmentActivity.a(paramActivity, localIntent, PublishHomeWorkFragment.class);
  }
  
  private void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2);
    if (m >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 2000L)
      {
        QQToast.a(getActivity(), "最多上传10张图片和视频", 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - m, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivityForResult(paramView, 259);
    InputMethodUtil.a(getActivity());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) {}
    for (int m = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4);; m = 0)
    {
      Object localObject2;
      if ((m > 0) && (!paramBoolean))
      {
        localObject1 = DialogUtil.a(getActivity(), 230);
        localObject2 = new ajow(this, paramCompoundButton);
        ((QQCustomDialog)localObject1).setMessage(2131430668);
        ((QQCustomDialog)localObject1).setPositiveButton(2131430669, (DialogInterface.OnClickListener)localObject2);
        ((QQCustomDialog)localObject1).setNegativeButton(2131430670, (DialogInterface.OnClickListener)localObject2);
        ((QQCustomDialog)localObject1).show();
      }
      Object localObject1 = a(7);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = (FormSwitchItem)a(FormSwitchItem.class, (View)((List)localObject1).get(0));
        if ((localObject1 != null) && (((FormSwitchItem)localObject1).a()) && (!this.jdField_d_of_type_Boolean))
        {
          localObject2 = DialogUtil.a(getActivity(), 230);
          ((QQCustomDialog)localObject2).setMessage("关闭在线提交后，学生将无法拍照提交口算作业。").setNegativeButton("取消", new ajog(this)).setPositiveButton("关闭", new ajof(this, (FormSwitchItem)localObject1, paramCompoundButton));
          this.jdField_d_of_type_Boolean = true;
          paramCompoundButton.setChecked(true);
          ((QQCustomDialog)localObject2).show();
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    Object localObject2 = localTroopLinkManager.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new TroopLinkManager.LinkParams();
    ((TroopLinkManager.LinkParams)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((TroopLinkManager.LinkParams)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((TroopLinkManager.LinkParams)localObject2).i = "";
    paramString = localTroopLinkManager.a((String)localObject1, (TroopLinkManager.LinkParams)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b();
      }
    }
    label100:
    do
    {
      return;
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramQQAppInterface.putExtra("url", paramString);
      paramContext.startActivity(paramQQAppInterface);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).overridePendingTransition(2131034380, 2131034131);
  }
  
  private void a(HomeworkInfo paramHomeworkInfo)
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
          if (localUploadEditItemInfo.e() == 1) {
            localArrayList1.add(localUploadEditItemInfo);
          } else if ((localUploadEditItemInfo.e() == 2) || (localUploadEditItemInfo.e() == 0)) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) && (paramHomeworkInfo != null))
    {
      a(2131430667);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramHomeworkInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, paramHomeworkInfo);
  }
  
  private void a(Pair paramPair)
  {
    if ((this.jdField_d_of_type_AndroidViewViewGroup == null) || (paramPair == null)) {
      return;
    }
    switch (((Integer)paramPair.first).intValue())
    {
    default: 
      return;
    case 1: 
      this.jdField_d_of_type_AndroidViewViewGroup.addView((View)paramPair.second);
      return;
    }
    this.jdField_c_of_type_AndroidViewViewGroup.addView((View)paramPair.second, 0);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide");
    }
    if (TextUtils.isEmpty(paramString)) {}
    label300:
    do
    {
      do
      {
        for (;;)
        {
          return;
          HomeworkConfig localHomeworkConfig = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localHomeworkConfig != null) {
            if (("语文".equals(paramString)) && (localHomeworkConfig.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localHomeworkConfig.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new BeginnerGuideDownloadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHomeworkConfig.jdField_b_of_type_JavaLangString, paramString, localHomeworkConfig.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_Ajoy, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!"数学".equals(paramString)) || (!localHomeworkConfig.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localHomeworkConfig.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new BeginnerGuideDownloadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHomeworkConfig.jdField_d_of_type_JavaLangString, paramString, localHomeworkConfig.jdField_e_of_type_JavaLangString);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_Ajoy, 7, true);
                  return;
                }
              }
              catch (Exception paramString) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide course not match");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onBeginnerGuidePrepared at " + paramString);
    }
    if (!isResumed()) {
      return;
    }
    BeginnerGuideFragment.a(getActivity(), getArguments(), paramInt);
    paramString = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0).edit();
    paramString.putBoolean(a(paramInt), false);
    paramString.apply();
    InputMethodUtil.a(getActivity());
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (("recite".equals(new JSONObject(paramString).getString("type"))) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublishHomeWorkFragment", 2, "onSpecialHomeWorkChanged error ", paramString);
    }
  }
  
  private void a(@NonNull ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((UploadEditItemInfo)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131430658, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + "等内容";
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean) {}
      for (int m = 0;; m = 8)
      {
        localView.setVisibility(m);
        this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
        return;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Ajoy.postDelayed(new ajol(this), 20L);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return false;
      str = paramJSONObject.optString("type");
    } while ((TextUtils.isEmpty(str)) || (("str".equals(str)) && (TextUtils.isEmpty(paramJSONObject.optString("text")))));
    return true;
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ajoy = new ajoy(this, Looper.getMainLooper());
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if (getActivity() == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label91;
      }
      getActivity().finish();
    }
    label91:
    do
    {
      return;
      localObject = (QQAppInterface)getActivity().getAppInterface();
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ajoe(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    } while (this.l);
    this.l = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  private void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 2000L)
      {
        QQToast.a(getActivity(), "最多上传10张图片和视频", 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
    InputMethodUtil.a(getActivity());
  }
  
  private void c()
  {
    if (this.mContentView == null) {}
    View localView;
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = a(2131368427);
      this.jdField_c_of_type_AndroidViewView = a(2131368431);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368440));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2130969915, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368426));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131368428));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131368436);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368429));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368430));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368432));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368433));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131368435));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131368434));
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new ajop(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      localView = a(2131368437);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131368438);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131368439);
    } while (localView == null);
    localView.setOnClickListener(this);
  }
  
  private void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 2000L)
      {
        QQToast.a(getActivity(), "最多上传6段语音", 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    l();
  }
  
  private void d()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("extra.GROUP_UIN");
      this.h = ((Bundle)localObject).getBoolean("BeginnerGuideFragment:from_beginner_guide", false);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_JavaLangString = str;
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "uin: " + str);
        }
        f();
        a(8000L);
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.e(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject = ((Bundle)localObject).getString("HomeWorkConstants:homework_default_request_key");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONObject((String)localObject).getJSONArray("c");
        return;
        QQToast.a(getActivity(), 2131430656, 0).a();
        getActivity().finish();
        return;
      }
      catch (Exception localException)
      {
        do
        {
          this.jdField_a_of_type_OrgJsonJSONArray = null;
        } while (!QLog.isColorLevel());
        QLog.e("PublishHomeWorkFragment", 2, "error when parse homework ", localException);
        return;
      }
    }
    QQToast.a(getActivity(), 2131430656, 0).a();
    getActivity().finish();
  }
  
  private void e()
  {
    setLeftButton(2131430643, new ajoq(this));
    setRightButton(2131430631, new ajor(this));
    setTitle(getResources().getString(2131430630));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new ajos(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new ajot(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131430650));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setData(this.jdField_a_of_type_OrgJsonJSONArray.toString());
    }
    ThreadManager.getUIHandler().postDelayed(new ajou(this), 550L);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    f();
  }
  
  private void f()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_Ajoy.sendMessage(localMessage);
  }
  
  private void g()
  {
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Integer)((Pair)((Iterator)localObject).next()).first).intValue() != 1);
    }
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
        if ((this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) || (this.jdField_b_of_type_AndroidViewViewGroup.getHeight() <= 0))
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 514;
          this.jdField_a_of_type_Ajoy.sendMessageDelayed((Message)localObject, 100L);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
  }
  
  private void h()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((Pair)localIterator.next());
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {}
    Object localObject3;
    for (Object localObject1 = "";; localObject1 = this.jdField_b_of_type_JavaLangString)
    {
      TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, this.jdField_d_of_type_JavaLangString });
      localObject2 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      localObject1 = new JSONArray();
      int n = ((JSONArray)localObject2).length();
      int m = 0;
      while (m < n)
      {
        localObject3 = ((JSONArray)localObject2).optJSONObject(m);
        if (a((JSONObject)localObject3)) {
          ((JSONArray)localObject1).put(localObject3);
        }
        m += 1;
      }
    }
    if (((JSONArray)localObject1).length() <= 0)
    {
      QQToast.a(getActivity(), 2131430636, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2 = new HomeworkInfo();
    ((HomeworkInfo)localObject2).jdField_b_of_type_Long = 0L;
    ((HomeworkInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((HomeworkInfo)localObject2).jdField_a_of_type_JavaLangString.trim()))
    {
      QQToast.a(getActivity(), 2131430637, 0).a();
      return;
    }
    if (!NetworkUtil.g(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131433227, 0).a();
      return;
    }
    try
    {
      ((HomeworkInfo)localObject2).jdField_b_of_type_Long = Long.parseLong(getActivity().app.c());
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        ((HomeworkInfo)localObject2).jdField_a_of_type_Long = 0L;
        localObject3 = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ((List)localObject3).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
            continue;
            if (!this.jdField_e_of_type_Boolean) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      ((JSONArray)localObject1).put(new JSONObject("{\"type\":\"calculation\"}"));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("c", localObject1);
      ((HomeworkInfo)localObject2).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((HomeworkInfo)localObject2).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = ((HomeworkInfo)localObject2);
      localObject1 = DialogUtil.a(getActivity(), 230);
      localObject2 = new ajov(this, (HomeworkInfo)localObject2);
      ((QQCustomDialog)localObject1).setMessage(2131430632);
      ((QQCustomDialog)localObject1).setPositiveButton(2131430640, (DialogInterface.OnClickListener)localObject2);
      ((QQCustomDialog)localObject1).setNegativeButton(2131430641, (DialogInterface.OnClickListener)localObject2);
      ((QQCustomDialog)localObject1).show();
      return;
      ((HomeworkInfo)localObject2).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((HomeworkInfo)localObject2).jdField_a_of_type_JavaUtilList = localJSONObject;
    }
  }
  
  private void j()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label349;
      }
      str1 = "";
      str3 = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) {
        break label357;
      }
      localObject = "";
      label26:
      if (!this.jdField_d_of_type_Boolean) {
        break label404;
      }
      str2 = "1";
    }
    catch (Exception localException)
    {
      label392:
      label404:
      for (;;)
      {
        String str1;
        String str3;
        Object localObject;
        label99:
        label357:
        continue;
        label349:
        String str2 = "0";
      }
    }
    TroopReportor.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_Boolean))
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label392;
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      TroopReportor.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      QQToast.a(getActivity(), 2131430663, 0).a();
      localObject = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2131034131, 2131034382);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString;
      break label26;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label99;
    }
  }
  
  private void k()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      HomeWorkTroopSelectorFragment.a(getActivity(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2130969418, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Ajoy);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(ScreenUtil.b * 0.3F));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(50);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a().setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ajoh(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(true);
    InputMethodUtil.a(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  private void n()
  {
    this.jdField_a_of_type_Ajoy.postDelayed(new ajoi(this), 400L);
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_" + "PublishHomeWorkFragment:show_beginner_guide" + "_" + paramInt;
  }
  
  List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof ajox)) && (((ajox)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  public List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!"语文".equals(paramString)) {
        break label107;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, "布置在线背诵", 2130839197, new ajom(this), null)));
      }
    }
    label107:
    while ((!"数学".equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, "需要学生拍照提交口算题", "开启后，系统将自动批改学生的口算题。", new ajon(this), null)));
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void a(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new ajok(this), 10L);
    a(paramBoolean);
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (paramInt = 8;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      if ("数学".equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
  }
  
  boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      Object localObject = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      int m = ((JSONArray)localObject).length();
      if (m <= 0) {
        return true;
      }
      if (m == 1)
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).getString("type");
          bool1 = bool2;
          if (TextUtils.isEmpty(str)) {
            return bool1;
          }
          if ("str".equals(str))
          {
            boolean bool3 = TextUtils.isEmpty(((JSONObject)localObject).getString("text"));
            bool1 = bool2;
            if (bool3) {
              return bool1;
            }
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      bool1 = false;
    }
    return bool1;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    b();
    c();
    d();
    e();
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2130969916;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt1)
    {
    }
    label217:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramIntent != null) && (paramInt2 == 257))
            {
              paramInt1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
              paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
              if (!TextUtils.isEmpty(paramIntent))
              {
                if (paramInt1 == -2147483648) {
                  break label217;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt1, paramIntent);
                this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
              }
            }
            for (;;)
            {
              a(paramIntent, bool);
              if ((!TextUtils.isEmpty(paramIntent)) && (QLog.isColorLevel())) {
                QLog.d("PublishHomeWorkFragment", 2, "提交新作业->" + paramIntent);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PublishHomeWorkFragment", 2, "return from entry");
              return;
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(EditItemInfoFactory.a(paramIntent));
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
              bool = true;
            }
          } while (paramInt2 != -1);
          if (!NetworkUtil.d(getActivity()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
            }
            QQToast.a(getActivity(), 2131430301, 0).a();
            return;
          }
          ImageUtil.a(getActivity(), this.jdField_c_of_type_JavaLangString);
          paramIntent = new ImageInfo(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
          return;
        } while ((paramIntent == null) || (paramInt2 != 262));
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
        paramIntent = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
        if (localArrayList != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
        }
        if (paramIntent != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll(paramIntent);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null);
      if (this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilList.get(0));
        return;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + "等" + this.jdField_b_of_type_JavaUtilList.size() + "个群");
  }
  
  public boolean onBackEvent()
  {
    if (!a())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      ajoj localajoj = new ajoj(this);
      localQQCustomDialog.setMessage(2131430633);
      localQQCustomDialog.setPositiveButton(2131430642, localajoj);
      localQQCustomDialog.setNegativeButton(2131430641, localajoj);
      localQQCustomDialog.show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131368436: 
    default: 
      return;
    case 2131368437: 
      a(paramView);
      return;
    case 2131368438: 
      b(paramView);
      return;
    case 2131368439: 
      c(paramView);
      return;
    }
    k();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    TroopHWJsPlugin.a();
    if (this.l)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.l = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Ajoy.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2131034131, 2131034382);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0))
    {
    default: 
      return;
    }
    this.g = ImageItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */