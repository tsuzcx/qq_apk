package com.tencent.mobileqq.fragment;

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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthHandler;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupPushData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.data.MsgbackupMsgGenerator;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConstant;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static String c;
  public static int d;
  public static MsgBackupGetQrRsp e;
  private final int A = 0;
  private final int B = 1;
  private final int C = 2;
  private final int D = 3;
  MsgBackupJniProxy a;
  long b;
  private String[] f = new String[10];
  private Integer g = new Integer(0);
  private Integer h = new Integer(0);
  private String[] i;
  private int j;
  private int k;
  private String l;
  private MsgBackupPushData m;
  private String n;
  private String o = HardCodeUtil.a(2131904791);
  private String p = HardCodeUtil.a(2131904808);
  private MsgBackupAuthHandler q;
  private MsgBackupConfirmQrRsp r;
  private MsgBackupQryStateRsp s;
  private MsgBackupObserver t = new MsgBackupSettingFragment.7(this);
  private MqqHandler u;
  private MqqHandler v;
  private QQProgressDialog w;
  private String x;
  private int y;
  private String z;
  
  private void a(Object paramObject)
  {
    StringBuilder localStringBuilder;
    if ((paramObject instanceof MsgBackupPushData))
    {
      paramObject = (MsgBackupPushData)paramObject;
      this.k = paramObject.b();
      this.l = paramObject.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProcessPush0x11b confirmQrRsp = ");
      localStringBuilder.append(paramObject);
      QLog.d("MsgBackup", 1, localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.8(this));
      return;
    }
    if ((paramObject instanceof Integer))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProcessPush0x11b data = ");
      localStringBuilder.append(paramObject);
      QLog.d("MsgBackup", 1, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = new File(paramString).listFiles(new MsgBackupSettingFragment.9(this));
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int i1 = 0;
      Object localObject2 = localObject1[0];
      localObject1 = BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath());
      if (localObject1 != null)
      {
        int i4 = ((Bitmap)localObject1).getWidth();
        int i2 = ((Bitmap)localObject1).getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i4, i2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        int i3 = i2 / 4;
        localPaint.setTextSize(i3);
        localCanvas.save();
        localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localCanvas.restore();
        i4 /= 2;
        int i5 = i2 / 2;
        localObject2 = ((File)localObject2).getName().split("\\.");
        if (localObject2 != null)
        {
          if (localObject2.length < 1) {
            return;
          }
          localObject2 = localObject2[0];
          while (i1 < paramInt)
          {
            i5 = localCanvas.save();
            localCanvas.drawText(String.valueOf(i1), i4, i2 - i3, localPaint);
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(File.separator);
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("_");
            ((StringBuilder)localObject3).append(i1);
            localObject3 = ((StringBuilder)localObject3).toString();
            File localFile = new File((String)localObject3);
            if (!localFile.exists()) {
              try
              {
                localFile.createNewFile();
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
            try
            {
              BitmapUtils.a(localBitmap, (String)localObject3);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            localCanvas.restoreToCount(i5);
            i1 += 1;
          }
          localBitmap.recycle();
          ((Bitmap)localObject1).recycle();
          this.v.sendEmptyMessage(3);
        }
      }
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.x = paramString1;
    this.y = paramInt1;
    this.z = paramString2;
    this.u.obtainMessage(0).sendToTarget();
    if (paramBoolean)
    {
      paramString1 = this.v.obtainMessage(2);
      paramString1.arg1 = paramInt2;
      paramString1.obj = paramString2;
      paramString1.sendToTarget();
      return;
    }
    this.u.sendEmptyMessage(3);
  }
  
  private void b(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      c();
      return;
    }
    a(HardCodeUtil.a(2131904811));
  }
  
  private void d()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.5(this));
  }
  
  private void e()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupSettingFragment.6(this));
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.z)) {
      return;
    }
    File[] arrayOfFile = new File(this.z).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i2 = arrayOfFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str1 = arrayOfFile[i1].getAbsolutePath();
        int i3 = this.y;
        String str2 = this.x;
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str1);
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        localIntent.putExtra("uin", str2);
        localIntent.putExtra("uintype", i3);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("send_in_background", true);
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
        localIntent.putExtra("PicContants.NEED_COMPRESS", false);
        localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
        new SendPhotoTask(getBaseActivity(), localIntent, null).run();
        i1 += 1;
      }
      this.u.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  public void a()
  {
    String str = getBaseActivity().app.getCurrentUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(".db");
    localObject = ((StringBuilder)localObject).toString();
    str = getBaseActivity().getDatabasePath((String)localObject).getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.a);
    localStringBuilder.append("test/");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    MsgBackupUtil.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str, new Object[] { localObject, Boolean.valueOf(FileUtils.copyFile(str, (String)localObject)) });
  }
  
  public void a(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 2)
    {
      if (i1 != 3) {
        return;
      }
      f();
      return;
    }
    a((String)paramMessage.obj, paramMessage.arg1);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.w == null) {
        this.w = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      }
      this.w.a(paramString);
      this.w.c(false);
      this.w.show();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarFragment", 2, paramString.toString());
      }
    }
  }
  
  public String[] b()
  {
    String[] arrayOfString = new String[2];
    Object localObject = (WifiManager)getBaseActivity().getApplicationContext().getSystemService("wifi");
    if (localObject != null)
    {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
      arrayOfString[0] = ((WifiInfo)localObject).getSSID();
      arrayOfString[1] = ((WifiInfo)localObject).getBSSID();
    }
    return arrayOfString;
  }
  
  public void c()
  {
    try
    {
      if ((this.w != null) && (this.w.isShowing()))
      {
        this.w.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarFragment", 2, localException.toString());
      }
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.q = ((MsgBackupAuthHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER));
    getBaseActivity().app.addObserver(this.t);
    this.vg.setRightButton(HardCodeUtil.a(2131904810));
    this.vg.setLeftButton(HardCodeUtil.a(2131898212));
    ((Button)this.mContentView.findViewById(2131437609)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131444668)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131431222)).setOnClickListener(this);
    this.mContentView.findViewById(2131444597).setOnClickListener(this);
    this.mContentView.findViewById(2131442920).setOnClickListener(this);
    this.mContentView.findViewById(2131447689).setOnClickListener(this);
    this.mContentView.findViewById(2131432675).setOnClickListener(this);
    this.mContentView.findViewById(2131442037).setOnClickListener(this);
    this.mContentView.findViewById(2131431575).setOnClickListener(this);
    this.mContentView.findViewById(2131430764).setOnClickListener(this);
    this.mContentView.findViewById(2131430762).setOnClickListener(this);
    this.mContentView.findViewById(2131431424).setOnClickListener(this);
    this.mContentView.findViewById(2131446304).setOnClickListener(this);
    this.mContentView.findViewById(2131431225).setOnClickListener(this);
    this.mContentView.findViewById(2131431233).setOnClickListener(this);
    this.mContentView.findViewById(2131435198).setOnClickListener(this);
    this.mContentView.findViewById(2131432546).setOnClickListener(this);
    this.mContentView.findViewById(2131445635).setOnClickListener(this);
    this.mContentView.findViewById(2131444667).setOnClickListener(this);
    this.mContentView.findViewById(2131444666).setOnClickListener(this);
    this.mContentView.findViewById(2131449205).setOnClickListener(this);
    this.mContentView.findViewById(2131449204).setOnClickListener(this);
    this.mContentView.findViewById(2131445636).setOnClickListener(this);
    this.mContentView.findViewById(2131438919).setOnClickListener(this);
    this.mContentView.findViewById(2131438929).setOnClickListener(this);
    this.mContentView.findViewById(2131449201).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131445635);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131445636);
    ((EditText)this.mContentView.findViewById(2131435827)).addTextChangedListener(new MsgBackupSettingFragment.1(this, paramLayoutInflater, paramViewGroup));
    paramLayoutInflater.setText(String.format(this.o, new Object[] { "10000" }));
    paramViewGroup.setText(String.format(this.p, new Object[] { "1000" }));
    paramViewGroup = PreferenceManager.getDefaultGlobalPreference(getBaseActivity());
    paramBundle = paramViewGroup.getString("msgbackup_uin", "");
    String str1 = paramViewGroup.getString("msgbackup_picfilepath", "");
    String str2 = paramViewGroup.getString("msgbackup_inputcount", "");
    String str3 = paramViewGroup.getString("msgbackup_isNeedGeneratedStr", "");
    if (!TextUtils.isEmpty(paramBundle))
    {
      int i1 = paramViewGroup.getInt("msgbackup_uintype", 0);
      ((EditText)this.mContentView.findViewById(2131432676)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131432677)).setText(String.valueOf(i1));
      ((EditText)this.mContentView.findViewById(2131433139)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131435827)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131435917)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.i = b();
    this.u = new MqqHandler(Looper.getMainLooper(), new MsgBackupSettingFragment.2(this));
    this.v = new MqqHandler(ThreadManager.getSubThreadLooper(), new MsgBackupSettingFragment.3(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131627815;
  }
  
  public void onClick(View paramView)
  {
    int i5 = paramView.getId();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131432676)).getText().toString();
    Object localObject5 = ((EditText)this.mContentView.findViewById(2131432677)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131435827)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131433139)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131435917)).getText().toString();
    boolean bool = "1".equals(localObject4);
    int i4 = 0;
    int i3 = 0;
    try
    {
      i2 = Integer.parseInt((String)localObject5);
    }
    catch (Exception localException1)
    {
      int i2;
      label136:
      break label136;
    }
    i2 = 0;
    try
    {
      i1 = Integer.parseInt((String)localObject3);
    }
    catch (Exception localException2)
    {
      int i1;
      label147:
      ArrayList localArrayList;
      break label147;
    }
    i1 = 0;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = c;
      i2 = d;
    }
    else
    {
      c = (String)localObject1;
      d = i2;
      localObject5 = PreferenceManager.getDefaultGlobalPreference(getBaseActivity());
      ((SharedPreferences)localObject5).edit().putString("msgbackup_uin", (String)localObject1).apply();
      ((SharedPreferences)localObject5).edit().putInt("msgbackup_uintype", i2).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_picfilepath", (String)localObject2).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_inputcount", (String)localObject3).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_isNeedGeneratedStr", (String)localObject4).apply();
    }
    localObject3 = MsgBackupManager.a();
    localObject4 = (MsgBackupAuthHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER);
    localObject5 = new MsgBackupUserData.Builder();
    localArrayList = new ArrayList(2);
    switch (i5)
    {
    default: 
      break;
    case 2131449205: 
      this.n = Uri.encode("111111111111111111");
      MsgBackupUtil.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.n });
      break;
    case 2131449204: 
      localObject1 = this.n;
      if (localObject1 != null) {
        MsgBackupUtil.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode((String)localObject1) });
      }
      break;
    case 2131449201: 
      d();
      localObject1 = MsgBackupUtil.a("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", "10.71.161.35", 8001, "'U}MXig2f9zi:$?_");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RESULT = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("MsgBackupSettingFragment", 1, ((StringBuilder)localObject2).toString());
      break;
    case 2131447689: 
      localObject1 = this.r;
      if (localObject1 != null) {
        ((MsgBackupAuthHandler)localObject4).a(((MsgBackupConfirmQrRsp)localObject1).a());
      } else {
        QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
      }
      break;
    case 2131446304: 
      e();
      break;
    case 2131445636: 
      a((String)localObject1, i2, (String)localObject2, i1, bool);
      break;
    case 2131445635: 
      localObject2 = new SessionInfo();
      ((SessionInfo)localObject2).b = ((String)localObject1);
      ((SessionInfo)localObject2).a = i2;
      i2 = i3;
      if (i1 > 0) {
        i2 = i1;
      }
      ThreadManager.newFreeThread(new MsgBackupSettingFragment.4(this, i2, (SessionInfo)localObject2), "msgbackup_testSendMsg", 1).start();
      break;
    case 2131445633: 
      a((String)localObject1, i2, (String)localObject2, i1);
      break;
    case 2131444668: 
      if ((this.h.intValue() != 0) && (this.g.intValue() != 0))
      {
        QQToast.makeText(getBaseActivity(), -1, HardCodeUtil.a(2131904809), 1).show();
        ((MsgBackupUserData.Builder)localObject5).c(this.i[1]);
        ((MsgBackupUserData.Builder)localObject5).b(this.i[0]);
        ((MsgBackupUserData.Builder)localObject5).a(this.f[0]);
        localArrayList.add(this.h);
        localArrayList.add(this.g);
        ((MsgBackupUserData.Builder)localObject5).a(localArrayList);
        ((MsgBackupUserData.Builder)localObject5).a(4);
        ((MsgBackupAuthHandler)localObject4).a(((MsgBackupUserData.Builder)localObject5).a(), 3, false);
      }
      break;
    case 2131444667: 
      this.q.a();
      break;
    case 2131444666: 
      if (!TextUtils.isEmpty(MsgBackupManager.b)) {
        this.q.b(MsgBackupManager.b);
      }
      break;
    case 2131444597: 
      localObject1 = e;
      if (localObject1 != null) {
        ((MsgBackupAuthHandler)localObject4).a(((MsgBackupGetQrRsp)localObject1).a(), 3);
      } else {
        QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
      }
      break;
    case 2131442920: 
      localObject1 = e;
      if (localObject1 != null) {
        ((MsgBackupAuthHandler)localObject4).c(((MsgBackupGetQrRsp)localObject1).a());
      } else {
        QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
      }
      break;
    case 2131438929: 
      i3 = i4;
      if (i1 > 0) {
        i3 = i1;
      }
      localObject2 = MsgbackupMsgGenerator.a(null, i3, (String)localObject1, i2, getBaseActivity().app.getCurrentUin());
      if (((List)localObject2).size() > 0) {
        MsgbackupMsgGenerator.a(getBaseActivity().app, (List)localObject2);
      }
      localObject1 = MessageRecord.getTableName((String)localObject1, i2);
      i1 = getBaseActivity().app.getMessageFacade().a((String)localObject1, 0L, 9223372036854775807L, false);
      localObject1 = (TextView)getBaseActivity().findViewById(2131438928);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("result:msgSize =  ");
      ((StringBuilder)localObject2).append(i1);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      break;
    case 2131438919: 
      MsgbackupMsgGenerator.a(getBaseActivity().app);
      break;
    case 2131437609: 
      d();
      break;
    case 2131435198: 
      QQToast.makeText(getBaseActivity(), -1, HardCodeUtil.a(2131904805), 1).show();
      break;
    case 2131432675: 
      ((MsgBackupManager)localObject3).h.clear();
      getBaseActivity().app.getProxyManager().g();
      localObject1 = RecentDataListManager.a((String)localObject1, i2);
      localObject1 = RecentDataListManager.a().a((String)localObject1);
      if (localObject1 != null)
      {
        ((MsgBackupManager)localObject3).h.add(localObject1);
        localObject1 = new MsgBackupRequest();
        ((MsgBackupRequest)localObject1).a = MsgBackupManager.a().h;
        ((MsgBackupRequest)localObject1).b = 0;
        ((MsgBackupManager)localObject3).a((MsgBackupRequest)localObject1);
      }
      else
      {
        QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
      }
      break;
    case 2131432546: 
      localObject1 = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131904812), new Object[] { "i am a hero!!!", localObject1 });
      localObject2 = MsgBackupJniProxy.decryptFromString((String)localObject1, "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131904797), new Object[] { localObject1, localObject2 });
      localObject2 = new byte[12];
      Object tmp1421_1419 = localObject2;
      tmp1421_1419[0] = 73;
      Object tmp1427_1421 = tmp1421_1419;
      tmp1427_1421[1] = 32;
      Object tmp1433_1427 = tmp1427_1421;
      tmp1433_1427[2] = 65;
      Object tmp1439_1433 = tmp1433_1427;
      tmp1439_1433[3] = 77;
      Object tmp1445_1439 = tmp1439_1433;
      tmp1445_1439[4] = 32;
      Object tmp1451_1445 = tmp1445_1439;
      tmp1451_1445[5] = 65;
      Object tmp1457_1451 = tmp1451_1445;
      tmp1457_1451[6] = 32;
      Object tmp1464_1457 = tmp1457_1451;
      tmp1464_1457[7] = 72;
      Object tmp1471_1464 = tmp1464_1457;
      tmp1471_1464[8] = 69;
      Object tmp1478_1471 = tmp1471_1464;
      tmp1478_1471[9] = 82;
      Object tmp1485_1478 = tmp1478_1471;
      tmp1485_1478[10] = 79;
      Object tmp1492_1485 = tmp1485_1478;
      tmp1492_1485[11] = 33;
      tmp1492_1485;
      localObject1 = MsgBackupJniProxy.encryptFromByteArray((byte[])localObject2, "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131904799), new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(localObject1.length) });
      localObject2 = MsgBackupJniProxy.decryptFromByteArray((byte[])localObject1, "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131904784), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(localObject2.length) });
      break;
    case 2131431575: 
      MsgBackupManager.a().c(null);
      break;
    case 2131431424: 
      a();
      break;
    case 2131431233: 
      a(this.m);
      break;
    case 2131431225: 
      a(this.m);
      break;
    case 2131431222: 
      if ((this.h.intValue() != 0) && (this.g.intValue() != 0))
      {
        QQToast.makeText(getBaseActivity(), -1, HardCodeUtil.a(2131904806), 1).show();
        if (e != null)
        {
          ((MsgBackupUserData.Builder)localObject5).c(this.i[1]);
          ((MsgBackupUserData.Builder)localObject5).b(this.i[0]);
          ((MsgBackupUserData.Builder)localObject5).a(this.f[0]);
          localArrayList.add(this.h);
          localArrayList.add(this.g);
          ((MsgBackupUserData.Builder)localObject5).a(localArrayList);
          ((MsgBackupUserData.Builder)localObject5).a(4);
          ((MsgBackupAuthHandler)localObject4).a(((MsgBackupUserData.Builder)localObject5).a(), e.a(), 3);
        }
        else
        {
          QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
        }
      }
      break;
    case 2131430764: 
      getBaseActivity().app.getMessageFacade().c((String)localObject1, i2);
      break;
    case 2131430762: 
      ((MsgBackupManager)localObject3).i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().app.removeObserver(this.t);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */