package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  static long F;
  public QfileTabBarView G = null;
  protected int H = -1;
  protected ArrayList<String> I = null;
  IBaseTabViewEvent J = null;
  RadioGroup.OnCheckedChangeListener K = null;
  RadioGroup L = null;
  RadioButton M = null;
  RadioButton N = null;
  RadioButton O = null;
  RadioButton P = null;
  TextView Q = null;
  TextView R = null;
  View S = null;
  RelativeLayout T = null;
  TextView U = null;
  RelativeLayout V = null;
  VerifyPwdView W = null;
  LinearLayout X = null;
  boolean Y = false;
  boolean Z = false;
  int aa = -1;
  String ab;
  int ac;
  int ad = -1;
  int ae;
  boolean af;
  FMActivity.FMTroopBusinessObserver ag = null;
  FMActivity.FMTroopObserver ah = null;
  String ai = null;
  int aj;
  int ak = -1;
  long al;
  View am = null;
  private int an;
  private int ao;
  private BroadcastReceiver ap = null;
  private float aq;
  private float ar;
  private HashMap<String, FMActivity.FileChooseTypeMessage> as;
  
  private void Q()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(2131895444);
    localQQCustomDialog.setTitle(2131895447);
    localQQCustomDialog.setNegativeButton(getString(2131895446), new FMActivity.1(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private boolean R()
  {
    int i = this.an;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 11)
    {
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 3)
        {
          bool1 = bool2;
          if (i != 5)
          {
            bool1 = bool2;
            if (i != 4) {
              if (i == 20) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
          }
        }
      }
    }
    if (!D()) {
      bool1 = false;
    }
    return bool1;
  }
  
  private void S()
  {
    RadioGroup localRadioGroup = this.L;
    if (localRadioGroup == null) {
      return;
    }
    int i = localRadioGroup.getChildCount();
    if (i < 1) {
      return;
    }
    this.L.getChildAt(i - 1).setBackgroundResource(2130851735);
  }
  
  private void T()
  {
    this.M = ((RadioButton)findViewById(2131437672));
    this.N = ((RadioButton)findViewById(2131444379));
    this.O = ((RadioButton)findViewById(2131430857));
    this.P = ((RadioButton)findViewById(2131432804));
    P();
  }
  
  private boolean U()
  {
    int i = this.an;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 3)
      {
        bool1 = bool2;
        if (i != 11)
        {
          if (i == 4) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private void V()
  {
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from")))
    {
      setLeftViewName(2131889351);
      return;
    }
    String str = this.ab;
    if ((str != null) && (str.trim().length() != 0) && (this.ac != -1))
    {
      setLeftViewName(2131887747);
      return;
    }
    setLeftViewName(2131887440);
  }
  
  private void W()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      float f = getResources().getDisplayMetrics().density;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(55.0F * f), (int)(f * 30.0F));
      this.O.setLayoutParams(localLayoutParams);
      this.O.setTextSize(14.0F);
      if (U())
      {
        this.P.setLayoutParams(localLayoutParams);
        this.P.setTextSize(14.0F);
      }
      this.M.setLayoutParams(localLayoutParams);
      this.M.setTextSize(14.0F);
      this.N.setLayoutParams(localLayoutParams);
      this.N.setTextSize(14.0F);
    }
  }
  
  private void X()
  {
    if (this.t == null) {
      this.g = getString(2131889280);
    }
    setTitle(this.g);
    Object localObject = this.L;
    if ((localObject != null) && (((RadioGroup)localObject).getVisibility() == 0)) {
      this.M.setSelected(true);
    }
    ad();
    if ((q()) && ((this.q) || (this.h == 5)))
    {
      this.R = ((TextView)findViewById(2131436180));
      setLeftViewName(2131889600);
      this.R.setOnClickListener(this);
      if ((this.aj <= 0) && (this.H != 1))
      {
        this.R.setVisibility(0);
      }
      else
      {
        this.R.setVisibility(4);
        this.R.setOnClickListener(null);
      }
      localObject = this.p.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", 1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (u() == 8) {
      this.R.setVisibility(4);
    }
  }
  
  private boolean Y()
  {
    if ((!this.Y) && (!this.Z))
    {
      this.M.setChecked(true);
      ad();
      SharedPreferences.Editor localEditor = this.p.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 1);
      localEditor.commit();
      if ((this.ae == 0) && (this.l)) {
        this.X.setVisibility(0);
      }
      if (this.z)
      {
        this.L.removeView(this.O);
        if (U()) {
          this.L.removeView(this.P);
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean Z()
  {
    if (this.Z)
    {
      ac();
      SharedPreferences.Editor localEditor = this.p.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", 0);
      localEditor.commit();
      if ((this.ae == 0) && (this.l)) {
        this.X.setVisibility(0);
      }
      return true;
    }
    return false;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("mini_file_paths_support", 1);
    localIntent.putExtra("file_number_limit", paramInt2);
    localIntent.putExtra("file_type", paramArrayList);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    localIntent.putExtra("qfile_entrance_type_key", 1);
    try
    {
      paramActivity.startActivityForResult(localIntent, paramInt1);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (this.H == 1)
    {
      d(true);
      b(10006);
      c(7);
      this.I = paramIntent.getStringArrayListExtra("file_type");
      FMDataCache.a(paramIntent.getIntExtra("file_number_limit", 20));
      this.as = new HashMap();
      this.as.put("media", new FMActivity.FileChooseTypeMessage(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 11, e(2131889604)));
      this.as.put("image", new FMActivity.FileChooseTypeMessage(".jpg|.bmp|.jpeg|.gif|.png|.ico|", 9, e(2131889610)));
      this.as.put("file", new FMActivity.FileChooseTypeMessage(".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", 10, e(2131889602)));
      this.as.put("video", new FMActivity.FileChooseTypeMessage(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", 13, e(2131889612)));
      this.as.put("audio", new FMActivity.FileChooseTypeMessage(".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", 12, e(2131889607)));
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.H == 1)
    {
      paramBundle.putInt("file_choose_extension_handle_type", 1);
      Object localObject1 = this.I;
      if ((localObject1 != null) && (!((ArrayList)localObject1).contains("all")))
      {
        Iterator localIterator = this.I.iterator();
        StringBuilder localStringBuilder;
        for (localObject1 = "";; localObject1 = localStringBuilder.toString())
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (String)localIterator.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(a((String)localObject2));
        }
      }
      Object localObject2 = "";
      paramBundle.putString("file_choose_extension_in_filter", (String)localObject2);
      paramBundle.putString("file_choose_extension_out_filter", "");
    }
  }
  
  private boolean a(Intent paramIntent, boolean paramBoolean)
  {
    return (paramBoolean) || (this.l) || (this.h == 5) || (this.j) || ((paramIntent != null) && (paramIntent.getIntExtra("approval_attachment_customid", -1) != -1));
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = q();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.h != 5)
      {
        bool1 = bool2;
        if (paramSharedPreferences.getBoolean("last_select_All", false))
        {
          bool1 = bool2;
          if (paramSharedPreferences.getBoolean("last_select_send", false)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void aa()
  {
    this.L.setVisibility(0);
    TextView localTextView = this.Q;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
    if (this.K == null) {
      ab();
    }
    this.L.setOnCheckedChangeListener(this.K);
  }
  
  private void ab()
  {
    this.K = new FMActivity.3(this);
  }
  
  private void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.b.setTabType(0);
    this.G.d();
    String str = this.ab;
    if ((str != null) && (str.trim().length() != 0)) {
      this.G.setUin(this.ab);
    }
    if (this.z)
    {
      this.G.setTabTitleList(new String[] { getString(2131889602) });
      this.G.a(4, getString(2131889602));
    }
    else if (this.m)
    {
      this.G.setTabTitleList(new String[] { getString(2131889600), getString(2131889602), getString(2131889610), getString(2131889604), getString(2131889601) });
      this.G.a(3, getString(2131889600));
      this.G.a(4, getString(2131889602));
      this.G.a(5, getString(2131889610));
      this.G.a(6, getString(2131889604));
      this.G.a(7, getString(2131889601));
    }
    else
    {
      this.G.setTabTitleList(new String[] { getString(2131889600), getString(2131889602), getString(2131896086), getString(2131889610), getString(2131889604), getString(2131889601) });
      this.G.b(3, getString(2131889600));
      this.G.b(4, getString(2131889602));
      this.G.b(21, getString(2131896086));
      this.G.b(5, getString(2131889610));
      this.G.b(6, getString(2131889604));
      this.G.b(7, getString(2131889601));
    }
    if (this.z)
    {
      this.G.setSelectedTab(4);
    }
    else
    {
      if ((this.Y) && (this.h == 0))
      {
        int i = this.aa;
        if ((i >= 3) && (i <= 7))
        {
          this.G.setSelectedTab(i);
          break label487;
        }
      }
      this.G.setSelectedTab(3);
    }
    label487:
    g(1);
    this.G.setVisibility(0);
    if (this.G.a == 1) {
      this.G.a(8);
    }
  }
  
  private void ad()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    g(2);
    this.b.setTabType(1);
    af();
    ag();
    int i = this.p.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).getInt("last_select_tab_type", -1);
    if ((this.Y) && ((this.h == 1) || (i == 1)))
    {
      i = this.aa;
      if ((i >= 8) && (i <= 14))
      {
        if (this.aj <= 0)
        {
          if ((i != 11) && (i != 9) && (i != 10) && (i != 8) && (i != 14) && (i != 5) && (i != 13) && (i != 12))
          {
            ae();
            break label257;
          }
          this.G.setSelectedTab(this.aa);
          break label257;
        }
        this.G.setSelectedTab(this.ak);
        break label257;
      }
    }
    if (7 != this.ad)
    {
      if (this.aj <= 0) {
        ae();
      } else {
        this.G.setSelectedTab(this.ak);
      }
    }
    else
    {
      i = this.ak;
      if (i != -1) {
        this.G.setSelectedTab(i);
      } else {
        this.G.setSelectedTab(9);
      }
    }
    label257:
    this.G.setVisibility(0);
  }
  
  private void ae()
  {
    if (this.H == 1)
    {
      ArrayList localArrayList = this.I;
      if ((localArrayList != null) && (!localArrayList.contains("all")))
      {
        this.G.setSelectedTab(b((String)this.I.get(0)));
        return;
      }
      this.G.setSelectedTab(10);
      return;
    }
    this.G.setSelectedTab(11);
  }
  
  private void af()
  {
    if (D())
    {
      if (this.Q == null) {
        this.Q = ((TextView)findViewById(2131437670));
      }
      this.Q.setOnClickListener(this);
      this.Q.setVisibility(0);
      if ((this.aj <= 0) && (this.H == -1))
      {
        this.Q.setVisibility(0);
      }
      else
      {
        this.Q.setVisibility(4);
        this.Q.setOnClickListener(null);
      }
      l();
      return;
    }
    a(this);
    TextView localTextView = this.Q;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void ag()
  {
    this.G.d();
    if (this.aj <= 0)
    {
      if (this.H == 1)
      {
        ah();
        return;
      }
      this.G.setTabTitleList(new String[] { getString(2131889604), getString(2131889610), getString(2131889602), getString(2131889601), getString(2131889609) });
      this.G.a(11, getString(2131889604));
      this.G.a(9, getString(2131889610));
      this.G.a(10, getString(2131889602));
      this.G.a(8, getString(2131889601));
      this.G.a(14, getString(2131889609));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.G.setTabTitleList(new String[] { getString(2131889602), getString(2131889610), getString(2131889612), getString(2131889607) });
    if (f(8))
    {
      this.G.a(10, getString(2131889602));
      localArrayList.add(Integer.valueOf(10));
    }
    if (f(4))
    {
      this.G.a(9, getString(2131889610));
      localArrayList.add(Integer.valueOf(9));
    }
    if (f(2))
    {
      this.G.a(13, getString(2131889612));
      localArrayList.add(Integer.valueOf(13));
    }
    if (f(1))
    {
      this.G.a(12, getString(2131889607));
      localArrayList.add(Integer.valueOf(12));
    }
    if (localArrayList.size() == 1) {
      this.G.a(8);
    }
  }
  
  private void ah()
  {
    Object localObject = this.I;
    if ((localObject != null) && (!((ArrayList)localObject).contains("all")))
    {
      int j = this.I.size();
      localObject = new String[j];
      int i = 0;
      while (i < j)
      {
        localObject[i] = c((String)this.I.get(i));
        i += 1;
      }
      this.G.setTabTitleList((String[])localObject);
      localObject = this.I.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.G.a(b(str), c(str));
      }
      this.aa = b((String)this.I.get(0));
    }
    else
    {
      this.G.setTabTitleList(new String[] { e(2131889602), e(2131889604), e(2131889610), e(2131889609) });
      this.G.a(10, e(2131889602));
      this.G.a(11, e(2131889604));
      this.G.a(9, e(2131889610));
      this.G.a(14, e(2131889609));
    }
    if (this.G.a == 1)
    {
      localObject = (LinearLayout)this.G.findViewById(2131437241);
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundColor(16777215);
      }
      localObject = this.G.findViewById(2131449814);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      this.G.a(8);
    }
  }
  
  private void ai()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initFavTabView");
    }
    this.b.setTabType(0);
    this.G.d();
    String str = this.ab;
    if ((str != null) && (str.trim().length() != 0)) {
      this.G.setUin(this.ab);
    }
    this.G.setTabTitleList(new String[] { getString(2131889604), getString(2131889610), getString(2131889602), getString(2131889601), getString(2131889609) });
    this.G.a(1200, getString(2131889604));
    this.G.a(1201, getString(2131889610));
    this.G.a(1202, getString(2131889602));
    this.G.a(1203, getString(2131889601));
    this.G.a(1204, getString(2131889609));
    if (this.Y)
    {
      int i = this.aa;
      if ((i >= 1200) && (i <= 1204))
      {
        this.G.setSelectedTab(i);
        break label254;
      }
    }
    this.G.setSelectedTab(1200);
    label254:
    this.G.setVisibility(0);
    if (this.G.a == 1) {
      this.G.a(8);
    }
    ReportController.b(this.p, "dc00898", "", "", "0X800AFA7", "0X800AFA7", 0, 0, "", "", "", "");
  }
  
  private void aj()
  {
    if ((this.i) || (this.k))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.ap == null)
      {
        this.ap = new FMActivity.5(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.p.getApplicationContext().registerReceiver(this.ap, localIntentFilter);
      }
    }
  }
  
  private void ak()
  {
    if (this.ap != null)
    {
      this.p.getApplicationContext().unregisterReceiver(this.ap);
      this.ap = null;
    }
  }
  
  private void al()
  {
    Object localObject = FMDataCache.g();
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Set)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(((FileInfo)localIterator.next()).d());
      }
    }
    localObject = null;
    ((IQQFileEngine)this.p.getRuntimeService(IQQFileEngine.class)).requestSendQlinkFile(this, (ArrayList)localObject, this.ai);
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initDownloadedTabView");
    }
    this.a.setSelectedAllMode();
    l();
    this.G.d();
    this.G.setTabTitleList(new String[] { getString(2131889612), getString(2131889610), getString(2131889602), getString(2131889601), getString(2131889609) });
    this.G.a(111, getString(2131889612));
    this.G.a(119, getString(2131889610));
    this.G.a(110, getString(2131889602));
    this.G.a(118, getString(2131889601));
    this.G.a(114, getString(2131889609));
    this.G.setSelectedTab(111);
    this.G.setVisibility(0);
  }
  
  private int b(String paramString)
  {
    HashMap localHashMap = this.as;
    if (localHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)localHashMap.get(paramString)).b;
    }
    return -1;
  }
  
  private void b(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("needRemember", false);
    } else {
      bool = false;
    }
    SharedPreferences localSharedPreferences = this.p.getApplication().getSharedPreferences("aio_last_select_file", 0);
    if (a(localSharedPreferences))
    {
      this.Z = true;
    }
    else if (a(paramIntent, bool))
    {
      if (this.h == -1) {
        this.h = localSharedPreferences.getInt("last_select_tab_type", -1);
      }
      this.aa = localSharedPreferences.getInt("last_select_tab_view", -1);
      if ((this.h != -1) && (this.aa != -1)) {
        this.Y = true;
      }
    }
    if ((!U()) && (this.h == 1408041718)) {
      this.h = 7;
    }
    if (paramIntent != null) {
      i(paramIntent.getIntExtra("smart_device_switch_tab_flag", 0));
    }
    paramIntent = localSharedPreferences.edit();
    paramIntent.putBoolean("last_select_All", false);
    paramIntent.putBoolean("last_select_send", false);
    paramIntent.commit();
  }
  
  private String c(String paramString)
  {
    HashMap localHashMap = this.as;
    if (localHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)localHashMap.get(paramString)).c;
    }
    return "";
  }
  
  private void g(int paramInt)
  {
    if (!R())
    {
      if (this.S.getVisibility() == 0) {
        this.S.setVisibility(8);
      }
      this.ao = 0;
      return;
    }
    if (paramInt == 0)
    {
      this.S.setVisibility(8);
      this.ao = 0;
      return;
    }
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            str = "";
          }
          else
          {
            str = getString(2131889317);
            this.ao = 4;
          }
        }
        else
        {
          str = getString(2131889318);
          this.ao = 3;
        }
      }
      else
      {
        str = getString(2131889314);
        this.ao = 2;
      }
    }
    else
    {
      str = getString(2131889315);
      this.ao = 1;
    }
    if (!TextUtils.isEmpty(str))
    {
      this.S.setVisibility(0);
      this.U.setText(str);
      return;
    }
    this.S.setVisibility(8);
    this.ao = 0;
  }
  
  private void h(int paramInt)
  {
    if ((q()) && (this.h != 5) && (this.h != 8) && (this.h != 6) && (!this.q))
    {
      a(2131627040);
      ((LinearLayout)findViewById(2131433123)).setLayoutParams(new RelativeLayout.LayoutParams(-1, paramInt));
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        D();
      }
    }
    else
    {
      setContentView(2131627040);
      ((RelativeLayout)findViewById(2131445043)).setVisibility(8);
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131433123);
    }
  }
  
  private void i(int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 1) && (paramInt != 2) && (paramInt != 4))
    {
      this.ak = 10;
      return;
    }
    if ((paramInt == 8) && (f(8)))
    {
      this.ak = 10;
      return;
    }
    if ((paramInt == 1) && (f(1)))
    {
      this.ak = 12;
      return;
    }
    if ((paramInt == 2) && (f(2)))
    {
      this.ak = 13;
      return;
    }
    if ((paramInt == 4) && (f(4)))
    {
      this.ak = 9;
      return;
    }
    this.ak = 10;
  }
  
  private void j(int paramInt)
  {
    this.G = ((QfileTabBarView)findViewById(2131433119));
    QfileTabBarView localQfileTabBarView = this.G;
    int i = 2;
    localQfileTabBarView.setAttribution(2);
    if (!this.m)
    {
      localQfileTabBarView = this.G;
      if (this.l) {
        i = 1;
      }
      localQfileTabBarView.setWYSubAppId(i);
    }
    if (q()) {
      this.G.setMemory(true);
    }
    V();
    if ((q()) && (paramInt != 5) && (paramInt != 8) && (!this.q))
    {
      this.L = ((RadioGroup)findViewById(2131444381));
      aa();
      if (!U()) {
        this.L.removeView(this.P);
      }
      if (this.m) {
        this.L.removeView(this.O);
      }
      W();
      if (Z()) {
        return;
      }
      if (Y()) {
        return;
      }
    }
    if (this.af)
    {
      findViewById(2131444381).setVisibility(8);
      findViewById(2131437668).setVisibility(0);
    }
    l();
    this.g = getString(2131896116);
    k(paramInt);
  }
  
  private void k(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt != 5)
          {
            if ((paramInt == 6) || (paramInt == 7)) {
              break label245;
            }
            if (paramInt != 8)
            {
              if (paramInt != 1408041718) {
                return;
              }
              this.g = getString(2131889270);
              setTitle(this.g);
              localRadioGroup = this.L;
              if ((localRadioGroup != null) && (localRadioGroup.getVisibility() == 0)) {
                this.P.setSelected(true);
              }
              ai();
              return;
            }
            this.g = HardCodeUtil.a(2131896075);
            setTitle(this.g);
            this.R = ((TextView)findViewById(2131436180));
            setLeftViewName(2131887440);
            getRightTextView().setVisibility(8);
            am();
          }
        }
        else
        {
          this.g = getString(2131889363);
          setTitle(this.g);
          localRadioGroup = this.L;
          if ((localRadioGroup != null) && (localRadioGroup.getVisibility() == 0)) {
            this.O.setSelected(true);
          }
          l(paramInt);
        }
      }
      else
      {
        this.g = this.t;
        if ((this.ae == 0) && (this.l)) {
          this.X.setVisibility(0);
        }
      }
      X();
    }
    else
    {
      this.g = getString(2131887720);
    }
    label245:
    setTitle(this.g);
    RadioGroup localRadioGroup = this.L;
    if ((localRadioGroup != null) && (localRadioGroup.getVisibility() == 0)) {
      this.N.setSelected(true);
    }
    ac();
  }
  
  private void l(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    ReportController.b(this.p, "dc00898", "", "", "0X8009E60", "0X8009E60", 0, 0, "", "", "", "");
    g(0);
    this.ao = 3;
    if (3 == paramInt) {
      f();
    }
    this.a.setVisibility(8);
    VerifyPwdView localVerifyPwdView = this.W;
    if (localVerifyPwdView != null) {
      localVerifyPwdView.a();
    }
    this.W = new VerifyPwdView(this);
    this.am = this.W.a(this.V, new FMActivity.4(this, paramInt));
    this.W.b();
    this.V.addView(this.am);
    this.am.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public int L()
  {
    QfileTabBarView localQfileTabBarView = this.G;
    if (localQfileTabBarView == null) {
      return super.L();
    }
    return localQfileTabBarView.getSortType();
  }
  
  public int[] M()
  {
    QfileTabBarView localQfileTabBarView = this.G;
    if (localQfileTabBarView == null) {
      return null;
    }
    return localQfileTabBarView.getSupprotSortType();
  }
  
  public int N()
  {
    return this.H;
  }
  
  public int O()
  {
    QfileTabBarView localQfileTabBarView = this.G;
    if (localQfileTabBarView == null) {
      return -1;
    }
    return localQfileTabBarView.getCurrentTabType();
  }
  
  protected void P()
  {
    boolean bool = QQTheme.isNowSimpleUI();
    ColorStateList localColorStateList;
    if (bool) {
      localColorStateList = getResources().getColorStateList(2131168193);
    } else {
      localColorStateList = getResources().getColorStateList(2131168206);
    }
    this.N.setTextColor(localColorStateList);
    this.M.setTextColor(localColorStateList);
    this.P.setTextColor(localColorStateList);
    this.O.setTextColor(localColorStateList);
    if (bool)
    {
      this.N.setPadding(0, 0, 0, 0);
      this.N.setGravity(17);
      this.O.setPadding(0, 0, 0, 0);
      this.O.setGravity(17);
      return;
    }
    this.N.setPadding(0, 0, ViewUtils.dpToPx(10.0F), 0);
    this.N.setGravity(21);
    this.O.setPadding(ViewUtils.dpToPx(10.0F), 0, 0, 0);
    this.O.setGravity(21);
  }
  
  public String a(String paramString)
  {
    HashMap localHashMap = this.as;
    if (localHashMap != null) {
      return ((FMActivity.FileChooseTypeMessage)localHashMap.get(paramString)).a;
    }
    return "";
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.J = paramIBaseTabViewEvent;
    if (this.h == 8) {
      this.a.setSelectEvent(this.J);
    }
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.G.a(paramArrayList);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    this.G.a(paramSet);
  }
  
  protected void b()
  {
    this.G.c();
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.G.b(paramArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.G == null) {
      return;
    }
    int i = 0;
    if (paramBoolean) {
      i = this.b.getLayoutParams().height;
    }
    int j = getResources().getDisplayMetrics().heightPixels;
    this.G.setTabFrameHeight(j - i);
  }
  
  public void c()
  {
    super.c();
    this.G.c();
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.G.c(paramArrayList);
  }
  
  public void d(int paramInt)
  {
    QfileTabBarView localQfileTabBarView = this.G;
    if (localQfileTabBarView == null)
    {
      super.d(paramInt);
      return;
    }
    localQfileTabBarView.setSortType(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (this.a != null)
    {
      this.a.g();
      if (paramMotionEvent.getAction() == 0)
      {
        this.aq = paramMotionEvent.getX();
        this.ar = paramMotionEvent.getY();
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ev.getY(");
        ((StringBuilder)localObject).append(paramMotionEvent.getY());
        ((StringBuilder)localObject).append("),");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("y: ");
        localStringBuilder.append(this.ar);
        localStringBuilder.append(" ,ev.getX(");
        localStringBuilder.append(paramMotionEvent.getX());
        localStringBuilder.append("),x: ");
        localStringBuilder.append(this.aq);
        localStringBuilder.append("  ");
        localStringBuilder.append(paramMotionEvent.getY() - this.ar);
        localStringBuilder.append(",");
        localStringBuilder.append(Math.abs(paramMotionEvent.getX() - this.aq));
        QLog.e("@@@@@", 1, new Object[] { localObject, localStringBuilder.toString() });
        if ((paramMotionEvent.getY() - this.ar < -200.0F) && (Math.abs(paramMotionEvent.getX() - this.aq) < 200.0F)) {
          this.a.a(false);
        }
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9999)
    {
      if (paramIntent == null) {
        return;
      }
      if (paramIntent.getIntExtra("qfile_send_bottom_bar_finish_result_code", 0) == -1)
      {
        setResult(paramInt2, new Intent(paramIntent));
        finish();
      }
    }
    if (paramInt2 == -1)
    {
      String str = this.ab;
      if ((str != null) && (str.trim().length() != 0))
      {
        if (((paramIntent == null) || (paramIntent.getExtras() == null) || ((paramIntent.getBooleanExtra("foward_editbar", false) != true) && (paramIntent.getBooleanExtra("destroy_last_activity", false) != true))) && (paramInt2 != 4)) {
          return;
        }
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openAIO(this, paramIntent);
        finish();
        return;
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    F += 1L;
    this.al = F;
    FMDataCache.d();
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.h = paramBundle.getIntExtra("tab_tab_type", -1);
    this.ad = paramBundle.getIntExtra("busiType", -1);
    this.ab = paramBundle.getStringExtra("uin");
    this.ac = paramBundle.getIntExtra("uintype", -1);
    this.i = paramBundle.getBooleanExtra("from_qlink", false);
    this.l = paramBundle.getBooleanExtra("from_aio", false);
    this.ae = paramBundle.getIntExtra("peerType", -1);
    this.af = paramBundle.getBooleanExtra("is_from_file_folder", false);
    this.H = paramBundle.getIntExtra("mini_file_paths_support", -1);
    a(paramBundle);
    this.an = paramBundle.getIntExtra("qfile_entrance_type_key", 0);
    this.ai = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate type[");
      localStringBuilder.append(this.h);
      localStringBuilder.append("],select[");
      localStringBuilder.append(q());
      localStringBuilder.append("]");
      QLog.d("FMActivity<FileAssistant>", 2, localStringBuilder.toString());
    }
    this.j = AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(this.ai);
    boolean bool;
    if (this.ae == 10014) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
    if (this.m)
    {
      this.n = paramBundle.getStringExtra("srcDiscGroup");
      this.o = paramBundle.getStringExtra("targetUin");
    }
    this.aj = paramBundle.getIntExtra("smart_device_support_flag", 0);
    if ((this.aj & 0xF) == 0) {
      this.aj = 0;
    }
    b(paramBundle);
    if ((!TextUtils.isEmpty(this.ab)) && (this.ac == -1)) {
      f(true);
    }
    h(getResources().getDisplayMetrics().heightPixels);
    this.V = ((RelativeLayout)findViewById(2131437901));
    this.X = ((LinearLayout)findViewById(2131442081));
    this.X.setOnClickListener(new FMActivity.2(this));
    this.S = findViewById(2131446824);
    this.T = ((RelativeLayout)findViewById(2131446823));
    this.T.setOnClickListener(this);
    this.U = ((TextView)findViewById(2131445433));
    g(0);
    if ((!TextUtils.isEmpty(this.ab)) && (this.ac == -1))
    {
      setLeftViewName(2131887440);
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
    }
    T();
    j(this.h);
    S();
    ((IQQFileEngine)this.p.getRuntimeService(IQQFileEngine.class)).clearNewDownload();
    aj();
    ((IQQFileEngine)this.p.getRuntimeService(IQQFileEngine.class)).initAppStoreSDK();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.G.e();
    Object localObject = this.W;
    if (localObject != null) {
      ((VerifyPwdView)localObject).a();
    }
    if (this.al == F) {
      FMDataCache.d();
    }
    ak();
    if (this.k)
    {
      localObject = new Intent("com.tencent.qlink.selectfileover");
      this.p.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  protected void doOnPause()
  {
    Object localObject = this.ag;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.ah;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.J;
    if (localObject != null) {
      ((IBaseTabViewEvent)localObject).u();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.ai != null))
    {
      Object localObject = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopPhotoHandlerName();
      localObject = (ITroopPhotoHandler)this.p.getBusinessHandler((String)localObject);
      this.ag = new FMActivity.FMTroopBusinessObserver(this);
      addObserver(this.ag);
      this.ah = new FMActivity.FMTroopObserver(this);
      addObserver(this.ah);
      ((ITroopPhotoHandler)localObject).a(this.ai);
    }
    super.doOnResume();
  }
  
  public String e(int paramInt)
  {
    return getString(paramInt);
  }
  
  public boolean f(int paramInt)
  {
    return (paramInt & this.aj) > 0;
  }
  
  public void finish()
  {
    super.finish();
    if (q())
    {
      if (this.h == 8) {
        return;
      }
      overridePendingTransition(2130771994, 2130771995);
    }
  }
  
  public ListView i()
  {
    QfileTabBarView localQfileTabBarView = this.G;
    if (localQfileTabBarView != null) {
      return localQfileTabBarView.getListView();
    }
    return null;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (d())
    {
      g();
      Object localObject;
      if ((paramView.getId() != 2131437670) && (paramView.getId() != 2131436180))
      {
        if (paramView.getId() == 2131445377)
        {
          localObject = new Intent(this, FMLocalFileActivity.class);
          ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
          ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
          ((Intent)localObject).putExtra(TeamWorkConstants.f, this.z);
          ((Intent)localObject).putExtra(TeamWorkConstants.g, this.A);
          ((Intent)localObject).putExtra("qrlogin_appid", this.C);
          ((Intent)localObject).putExtra("localSdCardfile", 1408041716);
          ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
          A().ak();
          startActivityForResult((Intent)localObject, 20002);
        }
        else if (paramView.getId() == 2131446823)
        {
          int i = this.ao;
          if (i != 0)
          {
            int j;
            if (i != 1)
            {
              if (i != 2) {
                break label597;
              }
              i = 17;
              j = 2;
            }
            else
            {
              i = 16;
              j = 1;
            }
            ReportController.b(null, "dc00898", "", "", "0X800AA90", "0X800AA90", j, 0, "0", "0", "", "");
            localObject = new Bundle();
            ((Bundle)localObject).putString("qfile_search_param_ex_params_target_uin", r());
            ((Bundle)localObject).putInt("qfile_search_param_exparams_peer_type", t());
            ((Bundle)localObject).putInt("qfile_search_param_exparams_busi_type", u());
            ((Bundle)localObject).putString("qfile_search_param_exparams_send_uin", s());
            ((Bundle)localObject).putInt("qfile_search_param_exparams_qlink_state", w());
            ((Bundle)localObject).putBoolean("qfile_search_param_exparams_qlink_ap_created", x());
            a((Bundle)localObject);
            ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startSeach(this, i, (Bundle)localObject);
          }
        }
      }
      else
      {
        localObject = new Intent(this, FMLocalFileActivity.class);
        ((Intent)localObject).putExtra("STRING_Show_Music_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Video_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Apk_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Pic_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_Driver_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_First_Space", false);
        ((Intent)localObject).putExtra(TeamWorkConstants.f, this.z);
        ((Intent)localObject).putExtra(TeamWorkConstants.g, this.A);
        ((Intent)localObject).putExtra("qrlogin_appid", this.C);
        ((Intent)localObject).putExtra("localSdCardfile", 1408041717);
        ((Intent)localObject).putExtra("STRING_Show_Download_Category", false);
        ((Intent)localObject).putExtra("STRING_Show_MyFile_Category", true);
        ((Intent)localObject).putExtra("select_file_support_send_docs_file", this.y);
        ((Intent)localObject).putExtra("select_file_only_docs_file", this.a.f());
        A().ad();
        startActivityForResult((Intent)localObject, 20001);
        overridePendingTransition(2130772344, 2130772347);
      }
    }
    label597:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    P();
  }
  
  public void onRestart()
  {
    super.onRestart();
    IBaseTabViewEvent localIBaseTabViewEvent = this.J;
    if (localIBaseTabViewEvent != null)
    {
      localIBaseTabViewEvent.t();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
    }
  }
  
  protected void onResume()
  {
    if (FMDataCache.e() > 0L) {
      B();
    }
    IBaseTabViewEvent localIBaseTabViewEvent = this.J;
    if (localIBaseTabViewEvent != null) {
      localIBaseTabViewEvent.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */