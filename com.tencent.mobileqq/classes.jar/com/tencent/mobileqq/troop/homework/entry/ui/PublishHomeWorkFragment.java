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
  protected ViewGroup A;
  protected ViewGroup B;
  protected QFormSimpleItem C;
  protected QFormSimpleItem D;
  protected FormSwitchItem E;
  protected boolean F = true;
  protected boolean G = false;
  protected boolean H = false;
  protected List<Pair<Integer, View>> I = new LinkedList();
  protected ActionSheet J = null;
  protected CommonRecordSoundPanel K = null;
  protected View L = null;
  protected HwkTimePicker M;
  protected String N = "";
  protected String O = "";
  protected boolean P = false;
  protected ArrayList<String> Q;
  protected List<String> R;
  protected boolean S = false;
  protected boolean T = false;
  protected String U;
  protected boolean V;
  protected AppInterface W;
  protected HomeworkHandler X;
  protected HomeworkObserver Y;
  protected HomeworkInfo Z = null;
  protected long a = 0L;
  protected PublishHomeWorkFragment.UIHandler aa = null;
  protected QQProgressDialog ab = null;
  protected int ac = 0;
  protected long ad = 0L;
  protected boolean ae = false;
  protected boolean af = false;
  protected HomeworkInfo ag = null;
  protected String ah = null;
  protected boolean ai = false;
  protected String aj = null;
  protected String ak = null;
  protected boolean al = false;
  protected boolean am = false;
  protected boolean an = false;
  protected long ao = 0L;
  protected SparseArrayCompat<IHomeworkHelper> ap = new SparseArrayCompat();
  protected BroadcastReceiver aq = new PublishHomeWorkFragment.19(this);
  protected int b = 1;
  protected Boolean c = Boolean.valueOf(true);
  protected InputMethodGuard d;
  protected ViewGroup e;
  protected EditText f;
  protected XMediaEditor g;
  protected View w;
  protected View x;
  protected ViewGroup y;
  protected ViewGroup z;
  
  private void B()
  {
    a(2, new DocsEntranceHelper(this, this.O));
    a(1, new WeiKeEntranceHelper(this, this.O));
  }
  
  private void C()
  {
    int i = 0;
    while (i < this.ap.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.ap;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i))).a();
      i += 1;
    }
  }
  
  private void D()
  {
    this.M = HwkTimeAdpater.a(getActivity());
    this.M.a(new PublishHomeWorkFragment.12(this));
    this.M.a(new PublishHomeWorkFragment.13(this));
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.ap.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.ap;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i))).a(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  private void a(int paramInt, IHomeworkHelper paramIHomeworkHelper)
  {
    this.ap.put(paramInt, paramIHomeworkHelper);
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
    int i = 0;
    while (i < this.ap.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.ap;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i))).a(paramJSONArray);
      i += 1;
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    int i = 0;
    while (i < this.ap.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.ap;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i))).a(paramJSONObject);
      i += 1;
    }
  }
  
  private void c(HomeworkInfo paramHomeworkInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(paramHomeworkInfo.k));
    localBundle.putString("group_id", this.O);
    localBundle.putString("title", paramHomeworkInfo.c);
    if (paramHomeworkInfo.f) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localBundle.putString("need_feedback", str1);
    localBundle.putString("c", paramHomeworkInfo.d);
    String str2 = this.W.getCurrentUin();
    paramHomeworkInfo = (TicketManager)this.W.getManager(2);
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
    localHashMap.put("CONTEXT", this.W.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new PublishHomeWorkFragment.20(this), 1000, null).a(localHashMap);
  }
  
  private boolean c(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L;
    if (this.M != null)
    {
      if (paramLong < l + 1L)
      {
        QQToast.makeText(getActivity(), 2131895254, 0).show();
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    int i = 0;
    while (i < this.ap.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.ap;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i))).a(paramInt);
      i += 1;
    }
  }
  
  private void d(HomeworkInfo paramHomeworkInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.O);
    localBundle.putString("course_id", "0");
    if (!this.N.isEmpty()) {
      localBundle.putString("course_name", this.N);
    } else {
      localBundle.putString("course_name", HardCodeUtil.a(2131895211));
    }
    localBundle.putString("title", paramHomeworkInfo.c);
    if (paramHomeworkInfo.f) {
      str = "1";
    } else {
      str = "0";
    }
    localBundle.putString("need_feedback", str);
    localBundle.putString("c", paramHomeworkInfo.d);
    localBundle.putString("team_id", "0");
    localBundle.putString("hw_type", "0");
    localBundle.putString("tsfeedback", String.valueOf(this.ao));
    if ((paramHomeworkInfo.j != null) && (paramHomeworkInfo.j.size() > 0))
    {
      int i = 0;
      str = "[";
      while (i < paramHomeworkInfo.j.size() - 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(String.valueOf(paramHomeworkInfo.j.get(i)));
        ((StringBuilder)localObject).append(",");
        str = ((StringBuilder)localObject).toString();
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(String.valueOf(paramHomeworkInfo.j.get(i)));
      ((StringBuilder)localObject).append("]");
      localBundle.putString("syncgids", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.W.getCurrentUin();
    paramHomeworkInfo = (TicketManager)this.W.getManager(2);
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
    localHashMap.put("CONTEXT", this.W.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new PublishHomeWorkFragment.21(this), 1000, null).a(localHashMap);
  }
  
  private void d(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.ap.size())
    {
      SparseArrayCompat localSparseArrayCompat = this.ap;
      ((IHomeworkHelper)localSparseArrayCompat.get(localSparseArrayCompat.keyAt(i))).b(paramBoolean);
      i += 1;
    }
  }
  
  protected void A()
  {
    QQProgressDialog localQQProgressDialog = this.ab;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.ab.dismiss();
      label23:
      this.ab = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  protected int a()
  {
    return 2131626709;
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
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131906608));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof ImageInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131906591));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof AudioInfo))
      {
        paramUploadEditItemInfo = new StringBuilder();
        paramUploadEditItemInfo.append(HardCodeUtil.a(2131906597));
        paramUploadEditItemInfo.append("");
        localArrayList.add(paramUploadEditItemInfo.toString());
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    boolean bool = ((IHomeworkHelper)this.ap.get(paramInt)).b();
    int i = 0;
    Object localObject;
    if ((bool) && (paramInt == 1))
    {
      if (this.M != null)
      {
        this.D.setVisibility(0);
        if (this.b == 1)
        {
          if (this.ao == 0L)
          {
            localObject = (HwkTimeAdpater)this.M.a();
            this.ao = HwkTimeAdpater.a();
            this.D.setRightText(b(this.ao));
          }
          this.D.setClickable(true);
        }
        else
        {
          if (this.Z.i != 0L) {
            this.D.setRightText(b(this.Z.i));
          }
          this.D.setClickable(false);
        }
      }
    }
    else
    {
      this.ao = 0L;
      this.D.setRightText("");
      this.D.setVisibility(8);
    }
    if (bool)
    {
      this.E.setEnabled(false);
      this.E.setChecked(true);
    }
    else
    {
      this.E.setEnabled(true);
    }
    while (i < this.ap.size())
    {
      localObject = this.ap;
      ((IHomeworkHelper)((SparseArrayCompat)localObject).get(((SparseArrayCompat)localObject).keyAt(i))).a(paramInt, bool);
      i += 1;
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    ArrayList localArrayList = this.g.c(paramInt);
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = localArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EditItemInfoBase)((Iterator)localObject1).next();
      if (localObject2 != null) {
        localJSONArray.put(((EditItemInfoBase)localObject2).d());
      }
    }
    if (!localArrayList.isEmpty())
    {
      localObject2 = this.O;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject1, this.ah, String.valueOf(localArrayList.size()), localJSONArray.toString() });
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      this.ah = "";
      this.ai = false;
      break;
    case 335: 
      this.ah = "student";
      this.ai = false;
      break;
    case 334: 
      this.ah = "parent";
      this.ai = false;
      break;
    case 333: 
      this.ah = "teacher";
      this.ai = true;
      break;
    case 332: 
      this.ah = "classteacher";
      this.ai = true;
    }
    this.aj = paramString1;
    this.ak = paramString2;
    paramString1 = this.O;
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    String str2 = this.ah;
    String str1;
    if (this.ai)
    {
      str1 = this.aj;
      paramString1 = str1;
      if (str1 != null) {
        break label174;
      }
    }
    else
    {
      str1 = this.ak;
      paramString1 = str1;
      if (str1 != null) {
        break label174;
      }
    }
    paramString1 = "";
    label174:
    if (this.b == 1) {
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
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131906589));
        paramHomeworkInfo = ((StringBuilder)localObject).toString();
      }
      int i = this.ac;
      if (i == 0)
      {
        this.ac = (i + 1);
        if ((this.g != null) && (!paramArrayList.isEmpty())) {
          this.g.a(paramArrayList);
        }
        paramArrayList = getString(2131895273, new Object[] { paramHomeworkInfo });
        QQToast.makeText(getActivity(), paramArrayList, 0).show();
      }
      else
      {
        paramArrayList = getString(2131895271, new Object[] { paramHomeworkInfo });
        QQToast.makeText(getActivity(), paramArrayList, 0).show();
      }
    }
    else if (paramInt == 1)
    {
      QQToast.makeText(getActivity(), 2131895242, 0).show();
    }
    else if (paramInt == 3)
    {
      QQToast.makeText(getActivity(), 2131895267, 0).show();
    }
    else if (paramInt == 2)
    {
      QQToast.makeText(getActivity(), 2131892111, 0).show();
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
    this.aa.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    e();
    h();
    B();
    g();
    p();
    if (MobileQQ.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.P = paramBoolean;
  }
  
  protected void a(HomeworkInfo paramHomeworkInfo)
  {
    this.Z = paramHomeworkInfo;
    paramHomeworkInfo = paramHomeworkInfo.d;
    for (;;)
    {
      int i;
      try
      {
        paramHomeworkInfo = new JSONObject(paramHomeworkInfo).getJSONArray("c");
        i = 0;
        if (i < paramHomeworkInfo.length())
        {
          JSONObject localJSONObject = paramHomeworkInfo.getJSONObject(i);
          if (localJSONObject != null) {
            b(localJSONObject);
          }
        }
        else
        {
          a(new JSONObject().put("c", paramHomeworkInfo).toString());
          if ((this.f != null) && (this.f.getText().toString().isEmpty()))
          {
            this.f.setText(this.Z.c);
            this.f.setFocusable(false);
            this.f.setFocusableInTouchMode(false);
          }
          return;
        }
      }
      catch (Exception paramHomeworkInfo)
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void a(Pair<Integer, View> paramPair)
  {
    if (this.A != null)
    {
      if (paramPair == null) {
        return;
      }
      int i = ((Integer)paramPair.first).intValue();
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.z.addView((View)paramPair.second, 0);
        return;
      }
      this.A.addView((View)paramPair.second);
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
          this.g.setDataByEdit(paramString);
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
        if (("recite".equals(new JSONObject(paramString).getString("type"))) && (this.E != null))
        {
          this.E.setChecked(true);
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
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131906600));
      paramArrayList = ((StringBuilder)localObject).toString();
    }
    paramArrayList = getString(2131895273, new Object[] { paramArrayList });
    QQToast.makeText(getActivity(), paramArrayList, 0).show();
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      u();
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
    return this.b;
  }
  
  public String b(long paramLong)
  {
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTimeInMillis(paramLong * 1000L);
    ((Calendar)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    int i = ((Calendar)localObject3).get(1);
    int j = ((Calendar)localObject3).get(2);
    int k = ((Calendar)localObject3).get(5);
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
    ((StringBuilder)localObject3).append(String.valueOf(i));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131895256));
    ((StringBuilder)localObject3).append(String.valueOf(j + 1));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131895255));
    ((StringBuilder)localObject3).append(String.valueOf(k));
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131895253));
    ((StringBuilder)localObject3).append(" ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
  
  List<Pair<Integer, View>> b(String paramString)
  {
    return new ArrayList();
  }
  
  protected void b(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.ab == null)
        {
          this.ab = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
          this.ab.setCancelable(false);
          this.ab.show();
        }
        this.ab.c(paramInt);
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
    int j = this.g.b(1) + this.g.b(2);
    if (j >= 10)
    {
      if (System.currentTimeMillis() - this.ad >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131906590));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131906594));
        QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
        this.ad = System.currentTimeMillis();
      }
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && ((getActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      getQBaseActivity().requestPermissions(new PublishHomeWorkFragment.10(this, j), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - j, getActivity(), this.W.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivityForResult(paramView, 259);
    InputMethodUtil.a(getActivity());
  }
  
  protected void b(HomeworkInfo paramHomeworkInfo)
  {
    Object localObject = this.g.getUploadErrorItemList();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        UploadEditItemInfo localUploadEditItemInfo = (UploadEditItemInfo)((Iterator)localObject).next();
        if (localUploadEditItemInfo != null) {
          if (localUploadEditItemInfo.i() == 1) {
            localArrayList1.add(localUploadEditItemInfo);
          } else if ((localUploadEditItemInfo.i() == 2) || (localUploadEditItemInfo.i() == 0)) {
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
      b(2131895252);
      int i = this.b;
      if (i == 1)
      {
        d(paramHomeworkInfo);
        return;
      }
      if (i == 2) {
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
    this.G = true;
    this.A.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.17(this), 10L);
    c(paramBoolean);
    View localView = this.L;
    if (paramBoolean) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    localView.setVisibility(paramInt);
    if (HomeWorkConstants.e.equals(this.N)) {
      this.L.setVisibility(8);
    }
  }
  
  public <T extends View> T c(int paramInt)
  {
    return this.t.findViewById(paramInt);
  }
  
  public XMediaEditor c()
  {
    return this.g;
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.g.b(1) + this.g.b(2) >= 10)
    {
      if (System.currentTimeMillis() - this.ad >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131906586));
        localStringBuilder.append(10);
        localStringBuilder.append(HardCodeUtil.a(2131906603));
        QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
        this.ad = System.currentTimeMillis();
      }
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (getActivity().checkSelfPermission("android.permission.CAMERA") != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      getQBaseActivity().requestPermissions(new PublishHomeWorkFragment.11(this), 3, new String[] { "android.permission.CAMERA" });
      return;
    }
    this.U = TroopHWJsPlugin.a(getActivity(), 260);
    InputMethodUtil.a(getActivity());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView = this.x;
      int i;
      if (this.F) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
      this.B.setVisibility(8);
    }
    else
    {
      this.x.setVisibility(8);
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.18(this), 20L);
    }
    d(paramBoolean);
  }
  
  public Bundle d()
  {
    Bundle localBundle = new Bundle();
    String str2 = this.ah;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localBundle.putString("reportIdentity", str1);
    if (this.ai)
    {
      str2 = this.aj;
      str1 = str2;
      if (str2 != null) {
        break label65;
      }
    }
    else
    {
      str2 = this.ak;
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
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.g.b(3) >= 6)
    {
      if (System.currentTimeMillis() - this.ad >= 2000L)
      {
        paramView = getActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131906588));
        localStringBuilder.append(6);
        localStringBuilder.append(HardCodeUtil.a(2131906595));
        QQToast.makeText(paramView, localStringBuilder.toString(), 0).show();
        this.ad = System.currentTimeMillis();
      }
      return;
    }
    w();
  }
  
  protected void e()
  {
    this.O = "";
    this.aa = new PublishHomeWorkFragment.UIHandler(this, Looper.getMainLooper());
    this.P = false;
    this.Q = new ArrayList();
    this.R = new ArrayList();
    if (getActivity() == null) {
      localObject = null;
    } else {
      localObject = (AppInterface)getQBaseActivity().getAppRuntime();
    }
    this.W = ((AppInterface)localObject);
    Object localObject = this.W;
    if (localObject == null)
    {
      getActivity().finish();
      return;
    }
    this.X = ((HomeworkHandler)((AppInterface)localObject).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName()));
    this.Y = new PublishHomeWorkFragment.2(this);
    this.W.addObserver(this.Y);
    if (!this.am)
    {
      this.am = true;
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
      ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
      getActivity().registerReceiver(this.aq, (IntentFilter)localObject);
    }
  }
  
  protected void e(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.M == null) {}
    try
    {
      D();
      if ((this.M.a() instanceof HwkTimeAdpater))
      {
        paramView = this.M;
        HwkTimeAdpater.a(paramView, (HwkTimeAdpater)paramView.a());
      }
      this.M.b();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  protected EditText f(View paramView)
  {
    EditText localEditText = null;
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      int i = 0;
      paramView = localEditText;
      while (i < j)
      {
        localEditText = f(localViewGroup.getChildAt(i));
        if (localEditText != null) {
          paramView = localEditText;
        }
        i += 1;
      }
      return paramView;
    }
    if (((paramView instanceof EditText)) && (paramView.isFocused())) {
      return (EditText)paramView;
    }
    return null;
  }
  
  protected void f()
  {
    if (this.N == null) {
      this.N = "";
    }
    if (!TextUtils.isEmpty(this.N))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("检测到你是");
        ((StringBuilder)localObject).append(this.N);
        ((StringBuilder)localObject).append("老师，将按照需求定制入口");
        QLog.d("PublishHomeWorkFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = b(this.N);
      if (localObject != null)
      {
        this.I.clear();
        this.I.addAll((Collection)localObject);
      }
    }
  }
  
  protected void g()
  {
    if (this.t == null) {
      return;
    }
    this.w = c(2131440867);
    this.L = c(2131447969);
    this.d = ((InputMethodGuard)c(2131435836));
    this.e = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131626708, null, false));
    this.f = ((EditText)this.e.findViewById(2131440856));
    this.g = ((XMediaEditor)c(2131440866));
    this.g.setHeaderView(this.e);
    this.x = c(2131429705);
    this.y = ((ViewGroup)c(2131446220));
    this.A = ((ViewGroup)c(2131446219));
    this.z = ((ViewGroup)c(2131446218));
    this.B = ((ViewGroup)c(2131431155));
    this.C = ((QFormSimpleItem)c(2131440862));
    this.C.setOnClickListener(this);
    this.D = ((QFormSimpleItem)c(2131440868));
    this.D.setVisibility(8);
    this.D.setOnClickListener(this);
    this.E = ((FormSwitchItem)c(2131440863));
    this.E.setChecked(true);
    this.E.setOnClickListener(this);
    this.P = this.E.a();
    this.E.setOnCheckedChangeListener(new PublishHomeWorkFragment.3(this));
    C();
    if (this.b == 2)
    {
      this.C.setVisibility(8);
      this.E.setVisibility(8);
    }
    this.d.setOnInputMethodChangeListener(this);
    Object localObject = c(2131440864);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = c(2131440871);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = c(2131440872);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    if (this.M == null) {}
    try
    {
      D();
      if ((this.M.a() instanceof HwkTimeAdpater))
      {
        localObject = this.M;
        HwkTimeAdpater.a((HwkTimePicker)localObject, (HwkTimeAdpater)((HwkTimePicker)localObject).a());
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void h()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("extra.GROUP_UIN");
      this.b = ((Bundle)localObject).getInt("publish_homework_mode", 1);
      this.a = ((Bundle)localObject).getLong("hw_id", 0L);
      if (!TextUtils.isEmpty(str))
      {
        this.O = str;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uin: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("PublishHomeWorkFragment", 2, ((StringBuilder)localObject).toString());
        }
        q();
        a(8000L);
        if (this.b == 1) {
          this.X.a(this.O, this.W.getCurrentUin());
        }
        if (this.b == 2)
        {
          if (this.a > 0L)
          {
            b(2131895251);
            this.X.a(this.a);
            return;
          }
          QQToast.makeText(getActivity(), 2131895269, 0).show();
          getActivity().finish();
        }
      }
      else
      {
        QQToast.makeText(getActivity(), 2131895269, 0).show();
        getActivity().finish();
      }
    }
    else
    {
      QQToast.makeText(getActivity(), 2131895269, 0).show();
      getActivity().finish();
    }
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
            this.Q.clear();
            this.Q.addAll((Collection)localObject1);
          }
          if (localObject2 != null)
          {
            this.R.clear();
            this.R.addAll((Collection)localObject2);
          }
          if (this.C != null) {
            if (this.R.isEmpty())
            {
              this.C.setRightText("");
            }
            else if (this.R.size() == 1)
            {
              this.C.setRightText((CharSequence)this.R.get(0));
            }
            else if (this.R.size() > 1)
            {
              localObject1 = this.C;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)this.R.get(0));
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131906598));
              ((StringBuilder)localObject2).append(this.R.size());
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131906593));
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
          QQToast.makeText(getActivity(), 2131894999, 0).show();
          return;
        }
        BaseImageUtil.b(getActivity(), this.U);
        localObject1 = new ImageInfo(this.U);
        this.g.a((EditItemInfoBase)localObject1);
      }
    }
    else
    {
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        int i = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        localObject1 = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (i != -2147483648)
          {
            this.g.a(i, (String)localObject1);
            this.g.invalidate();
            bool1 = false;
          }
          else
          {
            this.g.a(EditItemInfoFactory.a((String)localObject1));
            this.g.invalidate();
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
    if (!z())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      PublishHomeWorkFragment.16 local16 = new PublishHomeWorkFragment.16(this);
      int i = this.b;
      if (i == 1) {
        localQQCustomDialog.setMessage(2131895239);
      } else if (i == 2) {
        localQQCustomDialog.setMessage(2131895223);
      }
      localQQCustomDialog.setPositiveButton(2131895240, local16);
      localQQCustomDialog.setNegativeButton(2131895235, local16);
      localQQCustomDialog.show();
      InputMethodUtil.a(getActivity());
      return true;
    }
    InputMethodUtil.a(getActivity());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131440864) {
      b(paramView);
    } else if (i == 2131440871) {
      c(paramView);
    } else if (i == 2131440872) {
      d(paramView);
    } else if (i == 2131440862) {
      v();
    } else if (i == 2131440868) {
      e(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    HomeworkObserver localHomeworkObserver = this.Y;
    if (localHomeworkObserver != null)
    {
      AppInterface localAppInterface = this.W;
      if (localAppInterface != null) {
        localAppInterface.removeObserver(localHomeworkObserver);
      }
    }
    HWTroopUtils.a();
    if (this.am)
    {
      getActivity().unregisterReceiver(this.aq);
      this.am = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.aa.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.ae) {
      getActivity().overridePendingTransition(2130772007, 2130772436);
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
    this.V = ImageItem.a(this.g, paramIntent, this.V);
  }
  
  public void onPause()
  {
    super.onPause();
    InputMethodUtil.a(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.c.booleanValue())
    {
      this.c = Boolean.valueOf(false);
      return;
    }
    this.aa.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
  
  protected void p()
  {
    a(2131895234, new PublishHomeWorkFragment.5(this));
    c(2131895248, new PublishHomeWorkFragment.6(this));
    int i = this.b;
    if (i == 1) {
      a(getResources().getString(2131895250));
    } else if (i == 2) {
      a(getResources().getString(2131895226));
    }
    this.f.setOnFocusChangeListener(new PublishHomeWorkFragment.7(this));
    this.g.setFocusChangeListener(new PublishHomeWorkFragment.8(this));
    this.g.setSizeLimit(500);
    this.g.setHint(getString(2131895243));
    this.g.setExtraValue("troopuin", this.O);
    if (this.b == 1) {
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
    }
    this.f.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    q();
  }
  
  public void q()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.aa.sendMessage(localMessage);
  }
  
  protected void r()
  {
    boolean bool = this.I.isEmpty();
    int i = 1;
    Object localObject;
    if (!bool)
    {
      localObject = this.I.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Integer)((Pair)((Iterator)localObject).next()).first).intValue() == 1) {
          break label62;
        }
      }
    }
    i = 0;
    label62:
    if (i != 0)
    {
      c(this.d.a());
      if ((this.y.getVisibility() == 8) || (this.y.getHeight() <= 0))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 514;
        this.aa.sendMessageDelayed((Message)localObject, 100L);
      }
      this.y.setVisibility(0);
      return;
    }
    this.y.setVisibility(8);
  }
  
  protected void s()
  {
    if (!this.H)
    {
      Object localObject = this.I;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = this.I.iterator();
        while (((Iterator)localObject).hasNext()) {
          a((Pair)((Iterator)localObject).next());
        }
        this.H = true;
      }
    }
  }
  
  protected void t()
  {
    Object localObject3 = new JSONArray(this.g.getData());
    JSONArray localJSONArray = new JSONArray();
    int j = ((JSONArray)localObject3).length();
    Object localObject2 = this.O;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = this.ah;
    if (this.b == 1) {
      localObject2 = "1";
    } else {
      localObject2 = "2";
    }
    TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
    int i = 0;
    while (i < j)
    {
      localObject1 = ((JSONArray)localObject3).optJSONObject(i);
      if (a((JSONObject)localObject1)) {
        localJSONArray.put(localObject1);
      }
      i += 1;
    }
    if (localJSONArray.length() <= 0)
    {
      QQToast.makeText(getActivity(), 2131895237, 0).show();
      return;
    }
    if (this.Q.contains(this.O)) {
      this.Q.remove(this.O);
    }
    localObject1 = new HomeworkInfo();
    ((HomeworkInfo)localObject1).b = 0L;
    ((HomeworkInfo)localObject1).c = this.f.getText().toString();
    if (TextUtils.isEmpty(((HomeworkInfo)localObject1).c.trim()))
    {
      QQToast.makeText(getActivity(), 2131895238, 0).show();
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(getActivity()))
    {
      QQToast.makeText(getActivity(), 0, 2131892102, 0).show();
      return;
    }
    try
    {
      ((HomeworkInfo)localObject1).b = Long.parseLong(this.W.getCurrentUin());
      if (TextUtils.isEmpty(this.O)) {
        ((HomeworkInfo)localObject1).a = 0L;
      } else {
        ((HomeworkInfo)localObject1).a = Long.parseLong(this.O);
      }
      localObject2 = new ArrayList();
      localObject3 = this.Q.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject2).add(Long.valueOf(Long.parseLong((String)((Iterator)localObject3).next())));
      }
      ((HomeworkInfo)localObject1).j = ((List)localObject2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.S) {
      localJSONArray.put(new JSONObject("{\"type\":\"calculation\"}"));
    }
    a(localJSONArray);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("c", localJSONArray);
    ((HomeworkInfo)localObject1).f = this.P;
    ((HomeworkInfo)localObject1).d = localJSONObject.toString();
    if (this.b == 2)
    {
      ((HomeworkInfo)localObject1).k = this.a;
      ((HomeworkInfo)localObject1).f = this.Z.f;
    }
    this.ag = ((HomeworkInfo)localObject1);
    b((HomeworkInfo)localObject1);
  }
  
  protected void u()
  {
    try
    {
      localObject = this.O;
      str3 = "";
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = this.O;
      }
      str4 = this.ah;
      if ((this.ag == null) || (this.ag.d == null)) {
        break label438;
      }
      str1 = this.ag.d;
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
    if (this.P)
    {
      str2 = "1";
      TroopReportor.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { localObject, str4, str1, str2 });
      if (this.al)
      {
        if (this.O == null) {
          localObject = "";
        } else {
          localObject = this.O;
        }
        TroopReportor.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
      }
      d(1);
      if ((this.ag != null) && (this.ag.f))
      {
        if (this.O == null) {
          localObject = "";
        } else {
          localObject = this.O;
        }
        TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.ah });
      }
      if ((this.ag != null) && (this.ag.j != null) && (!this.ag.j.isEmpty()))
      {
        if (this.O == null) {
          localObject = str3;
        } else {
          localObject = this.O;
        }
        TroopReportor.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.ah, String.valueOf(this.ag.j.size()) });
      }
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      QQToast.makeText(getActivity(), 2131895249, 0).show();
      localObject = BaseAIOUtils.a(new Intent(), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.O);
      ((Intent)localObject).putExtra("uintype", 1);
      RouteUtils.a(getActivity(), (Intent)localObject, "/base/start/splash");
      getActivity().overridePendingTransition(2130772007, 2130772436);
      return;
    }
  }
  
  protected void v()
  {
    if (!TextUtils.isEmpty(this.O)) {
      HomeWorkTroopSelectorFragment.a(getActivity(), this.O, this.Q);
    }
  }
  
  protected void w()
  {
    if (this.J == null)
    {
      this.J = ActionSheet.create(getActivity());
      this.K = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131625892, null));
      this.K.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.K));
      this.K.setBackgroundColor(-1);
      this.K.a(this.W, getQBaseActivity(), this.aa, 0);
      this.K.setTimeOutTime(360000);
      this.K.setMinimumHeight((int)(ScreenUtil.SCREEN_HIGHT * 0.3F));
      this.J.addView(this.K);
      this.J.setAnimationTime(50);
      this.J.getActionContentView().setGravity(17);
      this.J.registerWatchDisMissActionListener(new PublishHomeWorkFragment.14(this));
    }
    this.K.e();
    this.J.setOutsideDismissEnableCompat(true);
    InputMethodUtil.a(getActivity());
    this.J.show();
  }
  
  protected void x()
  {
    this.J.dismiss();
  }
  
  protected void y()
  {
    this.aa.postDelayed(new PublishHomeWorkFragment.15(this), 400L);
  }
  
  boolean z()
  {
    try
    {
      Object localObject = new JSONArray(this.g.getData());
      int i = ((JSONArray)localObject).length();
      if (i > 0)
      {
        if (i == 1)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */