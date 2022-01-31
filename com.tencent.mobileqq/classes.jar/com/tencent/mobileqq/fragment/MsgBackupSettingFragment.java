package com.tencent.mobileqq.fragment;

import ajeu;
import alpo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import asbn;
import asbo;
import asbp;
import asbq;
import asbr;
import aubt;
import aubv;
import aucf;
import aucl;
import aucp;
import auct;
import aucw;
import aucz;
import aude;
import audf;
import aufb;
import aufh;
import bdcs;
import bepp;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import xmn;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static int a;
  public static auct a;
  public static String a;
  long jdField_a_of_type_Long;
  private aubt jdField_a_of_type_Aubt;
  private aubv jdField_a_of_type_Aubv = new asbq(this);
  private aucp jdField_a_of_type_Aucp;
  private aucw jdField_a_of_type_Aucw;
  private aucz jdField_a_of_type_Aucz;
  private bepp jdField_a_of_type_Bepp;
  private MsgBackupEndPoint jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  MsgBackupJniProxy jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private MsgBackupEndPoint jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  private String jdField_b_of_type_JavaLangString;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = alpo.a(2131707293);
  private final int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = alpo.a(2131707310);
  private final int jdField_f_of_type_Int = 1;
  private String jdField_f_of_type_JavaLangString;
  private final int jdField_g_of_type_Int = 2;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 3;
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof aucw))
    {
      paramObject = (aucw)paramObject;
      this.jdField_c_of_type_Int = paramObject.a();
      this.jdField_b_of_type_JavaLangString = paramObject.a();
      QLog.d("MsgBackup", 1, "onProcessPush0x11b confirmQrRsp = " + paramObject);
      ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.8(this));
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    QLog.d("MsgBackup", 1, "onProcessPush0x11b data = " + paramObject);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int m;
    int j;
    Bitmap localBitmap;
    Canvas localCanvas;
    Paint localPaint;
    int k;
    int n;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = new File(paramString).listFiles(new asbr(this));
        } while ((localObject1 == null) || (localObject1.length <= 0));
        localObject2 = localObject1[0];
        localObject1 = BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath());
        m = ((Bitmap)localObject1).getWidth();
        j = ((Bitmap)localObject1).getHeight();
      } while (localObject1 == null);
      localBitmap = Bitmap.createBitmap(m, j, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localPaint = new Paint();
      localPaint.setColor(-16777216);
      k = j / 4;
      localPaint.setTextSize(k);
      localCanvas.save();
      localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      localCanvas.restore();
      m /= 2;
      n = j / 2;
      localObject2 = ((File)localObject2).getName().split("\\.");
    } while ((localObject2 == null) || (localObject2.length < 1));
    Object localObject2 = localObject2[0];
    for (;;)
    {
      if (i < paramInt)
      {
        n = localCanvas.save();
        localCanvas.drawText(String.valueOf(i), m, j - k, localPaint);
        String str = paramString + File.separator + (String)localObject2 + "_" + i;
        File localFile = new File(str);
        if (!localFile.exists()) {}
        try
        {
          localFile.createNewFile();
        }
        catch (IOException localIOException)
        {
          try
          {
            for (;;)
            {
              xmn.a(localBitmap, str);
              localCanvas.restoreToCount(n);
              i += 1;
              break;
              localIOException = localIOException;
              localIOException.printStackTrace();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
    localBitmap.recycle();
    ((Bitmap)localObject1).recycle();
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.jdField_f_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_g_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0).sendToTarget();
    if (paramBoolean)
    {
      paramString1 = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(2);
      paramString1.arg1 = paramInt2;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  private void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      a(alpo.a(2131707314));
      return;
    }
    b();
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.5(this));
  }
  
  private void d()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.6(this));
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = new File(this.jdField_g_of_type_JavaLangString).listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length <= 0));
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfFile[i].getAbsolutePath();
      int k = this.jdField_d_of_type_Int;
      String str2 = this.jdField_f_of_type_JavaLangString;
      Intent localIntent = new Intent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", k);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      localIntent.putExtra("PicContants.NEED_COMPRESS", false);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      new SendPhotoTask(getActivity(), localIntent, null).run();
      i += 1;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 0L);
  }
  
  public void a()
  {
    String str1 = getActivity().app.c();
    String str2 = str1 + ".db";
    str1 = getActivity().getDatabasePath(str2).getAbsolutePath();
    str2 = aufb.jdField_a_of_type_JavaLangString + "test/" + str2;
    aufh.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str1, new Object[] { str2, Boolean.valueOf(bdcs.d(str1, str2)) });
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      a((String)paramMessage.obj, paramMessage.arg1);
      return;
    }
    e();
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Bepp == null) {
        this.jdField_a_of_type_Bepp = new bepp(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Bepp.a(paramString);
      this.jdField_a_of_type_Bepp.c(false);
      this.jdField_a_of_type_Bepp.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarFragment", 2, paramString.toString());
    }
  }
  
  public String[] a()
  {
    String[] arrayOfString = new String[2];
    Object localObject = (WifiManager)getActivity().getApplicationContext().getSystemService("wifi");
    if (localObject != null)
    {
      localObject = ((WifiManager)localObject).getConnectionInfo();
      arrayOfString[0] = ((WifiInfo)localObject).getSSID();
      arrayOfString[1] = ((WifiInfo)localObject).getBSSID();
    }
    return arrayOfString;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        this.jdField_a_of_type_Bepp.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("IphoneTitleBarFragment", 2, localException.toString());
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Aubt = ((aubt)getActivity().app.a(162));
    getActivity().app.addObserver(this.jdField_a_of_type_Aubv);
    this.vg.setRightButton(alpo.a(2131707312));
    this.vg.setLeftButton(alpo.a(2131707313));
    ((Button)this.mContentView.findViewById(2131369735)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131375631)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131364690)).setOnClickListener(this);
    this.mContentView.findViewById(2131375574).setOnClickListener(this);
    this.mContentView.findViewById(2131373925).setOnClickListener(this);
    this.mContentView.findViewById(2131378075).setOnClickListener(this);
    this.mContentView.findViewById(2131365875).setOnClickListener(this);
    this.mContentView.findViewById(2131373240).setOnClickListener(this);
    this.mContentView.findViewById(2131364981).setOnClickListener(this);
    this.mContentView.findViewById(2131364308).setOnClickListener(this);
    this.mContentView.findViewById(2131364307).setOnClickListener(this);
    this.mContentView.findViewById(2131364858).setOnClickListener(this);
    this.mContentView.findViewById(2131376938).setOnClickListener(this);
    this.mContentView.findViewById(2131364691).setOnClickListener(this);
    this.mContentView.findViewById(2131364695).setOnClickListener(this);
    this.mContentView.findViewById(2131367794).setOnClickListener(this);
    this.mContentView.findViewById(2131365773).setOnClickListener(this);
    this.mContentView.findViewById(2131376378).setOnClickListener(this);
    this.mContentView.findViewById(2131375630).setOnClickListener(this);
    this.mContentView.findViewById(2131375629).setOnClickListener(this);
    this.mContentView.findViewById(2131379347).setOnClickListener(this);
    this.mContentView.findViewById(2131379346).setOnClickListener(this);
    this.mContentView.findViewById(2131376379).setOnClickListener(this);
    this.mContentView.findViewById(2131370772).setOnClickListener(this);
    this.mContentView.findViewById(2131370790).setOnClickListener(this);
    this.mContentView.findViewById(2131379343).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131376378);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131376379);
    ((EditText)this.mContentView.findViewById(2131368346)).addTextChangedListener(new asbn(this, paramLayoutInflater, paramViewGroup));
    paramLayoutInflater.setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { "10000" }));
    paramViewGroup.setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { "1000" }));
    paramViewGroup = PreferenceManager.getDefaultGlobalPreference(getActivity());
    paramBundle = paramViewGroup.getString("msgbackup_uin", "");
    String str1 = paramViewGroup.getString("msgbackup_picfilepath", "");
    String str2 = paramViewGroup.getString("msgbackup_inputcount", "");
    String str3 = paramViewGroup.getString("msgbackup_isNeedGeneratedStr", "");
    if (!TextUtils.isEmpty(paramBundle))
    {
      int i = paramViewGroup.getInt("msgbackup_uintype", 0);
      ((EditText)this.mContentView.findViewById(2131365876)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131365877)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131366334)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131368346)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131368428)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.jdField_a_of_type_ArrayOfJavaLangString = a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new asbo(this));
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new asbp(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131561276;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    paramView = ((EditText)this.mContentView.findViewById(2131365876)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131365877)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131368346)).getText().toString();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131366334)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131368428)).getText().toString();
    boolean bool;
    int j;
    int i;
    if ("1".equals(localObject3))
    {
      bool = true;
      j = 0;
      i = 0;
    }
    try
    {
      k = Integer.parseInt((String)localObject4);
      j = k;
    }
    catch (Exception localException1)
    {
      int k;
      label138:
      label148:
      label163:
      ArrayList localArrayList;
      break label138;
    }
    try
    {
      k = Integer.parseInt((String)localObject2);
      i = k;
    }
    catch (Exception localException2)
    {
      break label148;
    }
    if (TextUtils.isEmpty(paramView))
    {
      paramView = jdField_a_of_type_JavaLangString;
      j = jdField_a_of_type_Int;
      localObject2 = aucf.a();
      localObject3 = (aubt)getActivity().app.a(162);
      localObject4 = new aude();
      localArrayList = new ArrayList(2);
    }
    switch (m)
    {
    case 2131373240: 
    default: 
    case 2131369735: 
    case 2131375631: 
    case 2131364690: 
    case 2131375574: 
    case 2131373925: 
    case 2131378075: 
    case 2131365875: 
    case 2131364981: 
    case 2131376378: 
    case 2131376379: 
    case 2131376376: 
    case 2131364308: 
    case 2131364307: 
    case 2131364858: 
    case 2131376938: 
    case 2131364691: 
    case 2131364695: 
    case 2131367794: 
    case 2131365773: 
    case 2131375630: 
    case 2131375629: 
    case 2131379347: 
    case 2131379346: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              bool = false;
              break;
              jdField_a_of_type_JavaLangString = paramView;
              jdField_a_of_type_Int = j;
              localObject4 = PreferenceManager.getDefaultGlobalPreference(getActivity());
              ((SharedPreferences)localObject4).edit().putString("msgbackup_uin", paramView).apply();
              ((SharedPreferences)localObject4).edit().putInt("msgbackup_uintype", j).apply();
              ((SharedPreferences)localObject4).edit().putString("msgbackup_picfilepath", (String)localObject1).apply();
              ((SharedPreferences)localObject4).edit().putString("msgbackup_inputcount", (String)localObject2).apply();
              ((SharedPreferences)localObject4).edit().putString("msgbackup_isNeedGeneratedStr", (String)localObject3).apply();
              break label163;
              c();
              return;
            } while ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null));
            QQToast.a(getActivity(), -1, alpo.a(2131707311), 1).a();
            ((aude)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((aude)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((aude)localObject4).a(aufh.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((aude)localObject4).a(localArrayList);
            ((aude)localObject4).a(4);
            ((aubt)localObject3).a(((aude)localObject4).a(), 3, false);
            return;
          } while ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null));
          QQToast.a(getActivity(), -1, alpo.a(2131707308), 1).a();
          if (jdField_a_of_type_Auct != null)
          {
            ((aude)localObject4).c(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
            ((aude)localObject4).b(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
            ((aude)localObject4).a(aufh.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            localArrayList.add(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port));
            ((aude)localObject4).a(localArrayList);
            ((aude)localObject4).a(4);
            ((aubt)localObject3).a(((aude)localObject4).a(), jdField_a_of_type_Auct.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Auct != null)
          {
            ((aubt)localObject3).a(jdField_a_of_type_Auct.a(), 3);
            return;
          }
          QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
          return;
          if (jdField_a_of_type_Auct != null)
          {
            ((aubt)localObject3).c(jdField_a_of_type_Auct.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
          return;
          if (this.jdField_a_of_type_Aucp != null)
          {
            ((aubt)localObject3).a(this.jdField_a_of_type_Aucp.a());
            return;
          }
          QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
          return;
          ((aucf)localObject2).jdField_a_of_type_JavaUtilHashSet.clear();
          getActivity().app.a().a();
          paramView = ajeu.a(paramView, j);
          paramView = ajeu.a().a(paramView);
          if (paramView != null)
          {
            ((aucf)localObject2).jdField_a_of_type_JavaUtilHashSet.add(paramView);
            paramView = new aucl();
            paramView.jdField_a_of_type_JavaUtilHashSet = aucf.a().jdField_a_of_type_JavaUtilHashSet;
            paramView.jdField_a_of_type_Int = 0;
            ((aucf)localObject2).a(paramView);
            return;
          }
          QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
          return;
          aucf.a().c(null);
          return;
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramView;
          ((SessionInfo)localObject1).jdField_a_of_type_Int = j;
          if (i > 0) {}
          for (;;)
          {
            ThreadManager.newFreeThread(new MsgBackupSettingFragment.4(this, i, (SessionInfo)localObject1), "msgbackup_testSendMsg", 1).start();
            return;
            i = 0;
          }
          a(paramView, j, (String)localObject1, i, bool);
          return;
          a(paramView, j, (String)localObject1, i);
          return;
          getActivity().app.a().a(paramView, j);
          return;
          ((aucf)localObject2).f();
          return;
          a();
          return;
          d();
          return;
          a(this.jdField_a_of_type_Aucw);
          return;
          a(this.jdField_a_of_type_Aucw);
          return;
          QQToast.a(getActivity(), -1, alpo.a(2131707307), 1).a();
          return;
          paramView = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
          aufh.a("MsgBackup", alpo.a(2131707315), new Object[] { "i am a hero!!!", paramView });
          localObject1 = MsgBackupJniProxy.decryptFromString(paramView, "1111111111111111");
          aufh.a("MsgBackup", alpo.a(2131707299), new Object[] { paramView, localObject1 });
          localObject1 = new byte[12];
          Object tmp1273_1271 = localObject1;
          tmp1273_1271[0] = 73;
          Object tmp1279_1273 = tmp1273_1271;
          tmp1279_1273[1] = 32;
          Object tmp1285_1279 = tmp1279_1273;
          tmp1285_1279[2] = 65;
          Object tmp1291_1285 = tmp1285_1279;
          tmp1291_1285[3] = 77;
          Object tmp1297_1291 = tmp1291_1285;
          tmp1297_1291[4] = 32;
          Object tmp1303_1297 = tmp1297_1291;
          tmp1303_1297[5] = 65;
          Object tmp1309_1303 = tmp1303_1297;
          tmp1309_1303[6] = 32;
          Object tmp1316_1309 = tmp1309_1303;
          tmp1316_1309[7] = 72;
          Object tmp1323_1316 = tmp1316_1309;
          tmp1323_1316[8] = 69;
          Object tmp1330_1323 = tmp1323_1316;
          tmp1330_1323[9] = 82;
          Object tmp1337_1330 = tmp1330_1323;
          tmp1337_1330[10] = 79;
          Object tmp1344_1337 = tmp1337_1330;
          tmp1344_1337[11] = 33;
          tmp1344_1337;
          paramView = MsgBackupJniProxy.encryptFromByteArray((byte[])localObject1, "1111111111111111");
          aufh.a("MsgBackup", alpo.a(2131707301), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(paramView.length) });
          localObject1 = MsgBackupJniProxy.decryptFromByteArray(paramView, "1111111111111111");
          aufh.a("MsgBackup", alpo.a(2131707286), new Object[] { Integer.valueOf(paramView.length), Integer.valueOf(localObject1.length) });
          return;
          this.jdField_a_of_type_Aubt.a();
          return;
        } while (TextUtils.isEmpty(aucf.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_Aubt.b(aucf.jdField_a_of_type_JavaLangString);
        return;
        this.jdField_c_of_type_JavaLangString = Uri.encode("111111111111111111");
        aufh.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.jdField_c_of_type_JavaLangString });
        return;
      } while (this.jdField_c_of_type_JavaLangString == null);
      aufh.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode(this.jdField_c_of_type_JavaLangString) });
      return;
    case 2131370772: 
      audf.a(getActivity().app);
      return;
    case 2131370790: 
      if (i > 0) {}
      for (;;)
      {
        localObject1 = audf.a(null, i, paramView, j, getActivity().app.c());
        if (((List)localObject1).size() > 0) {
          audf.a(getActivity().app, (List)localObject1);
        }
        paramView = MessageRecord.getTableName(paramView, j);
        i = getActivity().app.a().a(paramView, 0L, 9223372036854775807L, false);
        ((TextView)getActivity().findViewById(2131370789)).setText("result:msgSize =  " + i);
        return;
        i = 0;
      }
    }
    c();
    paramView = aufh.a("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", aufh.a("10.71.161.35"), 8001, "'U}MXig2f9zi:$?_");
    QLog.e("MsgBackupSettingFragment", 1, "RESULT = " + paramView);
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_Aubv);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */