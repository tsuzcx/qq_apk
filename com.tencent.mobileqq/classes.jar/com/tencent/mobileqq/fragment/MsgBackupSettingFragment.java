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
  public static int a;
  public static MsgBackupGetQrRsp a;
  public static String a;
  long jdField_a_of_type_Long;
  private MsgBackupAuthHandler jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthHandler;
  private MsgBackupObserver jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver = new MsgBackupSettingFragment.7(this);
  private MsgBackupConfirmQrRsp jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupConfirmQrRsp;
  private MsgBackupPushData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupPushData;
  private MsgBackupQryStateRsp jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupQryStateRsp;
  MsgBackupJniProxy jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Integer jdField_a_of_type_JavaLangInteger = new Integer(0);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[10];
  private int jdField_b_of_type_Int;
  private Integer jdField_b_of_type_JavaLangInteger = new Integer(0);
  private String jdField_b_of_type_JavaLangString;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131706948);
  private final int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131706965);
  private final int jdField_f_of_type_Int = 1;
  private String jdField_f_of_type_JavaLangString;
  private final int jdField_g_of_type_Int = 2;
  private String jdField_g_of_type_JavaLangString;
  private final int h = 3;
  
  private void a(Object paramObject)
  {
    StringBuilder localStringBuilder;
    if ((paramObject instanceof MsgBackupPushData))
    {
      paramObject = (MsgBackupPushData)paramObject;
      this.jdField_c_of_type_Int = paramObject.a();
      this.jdField_b_of_type_JavaLangString = paramObject.a();
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
      int i = 0;
      Object localObject2 = localObject1[0];
      localObject1 = BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath());
      if (localObject1 != null)
      {
        int m = ((Bitmap)localObject1).getWidth();
        int j = ((Bitmap)localObject1).getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(m, j, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        int k = j / 4;
        localPaint.setTextSize(k);
        localCanvas.save();
        localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localCanvas.restore();
        m /= 2;
        int n = j / 2;
        localObject2 = ((File)localObject2).getName().split("\\.");
        if (localObject2 != null)
        {
          if (localObject2.length < 1) {
            return;
          }
          localObject2 = localObject2[0];
          while (i < paramInt)
          {
            n = localCanvas.save();
            localCanvas.drawText(String.valueOf(i), m, j - k, localPaint);
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(File.separator);
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append("_");
            ((StringBuilder)localObject3).append(i);
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
            localCanvas.restoreToCount(n);
            i += 1;
          }
          localBitmap.recycle();
          ((Bitmap)localObject1).recycle();
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
        }
      }
    }
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
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      b();
      return;
    }
    a(HardCodeUtil.a(2131706969));
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
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      return;
    }
    File[] arrayOfFile = new File(this.jdField_g_of_type_JavaLangString).listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
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
        new SendPhotoTask(getBaseActivity(), localIntent, null).run();
        i += 1;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 0L);
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
    localStringBuilder.append(MsgBackupConstant.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("test/");
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    MsgBackupUtil.a("qqdb copy fromPath = %s,toPath = %s,result = %b", str, new Object[] { localObject, Boolean.valueOf(FileUtils.copyFile(str, (String)localObject)) });
  }
  
  public void a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3) {
        return;
      }
      e();
      return;
    }
    a((String)paramMessage.obj, paramMessage.arg1);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarFragment", 2, paramString.toString());
      }
    }
  }
  
  public String[] a()
  {
    String[] arrayOfString = new String[2];
    Object localObject = (WifiManager)getBaseActivity().getApplicationContext().getSystemService("wifi");
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthHandler = ((MsgBackupAuthHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER));
    getBaseActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    this.vg.setRightButton(HardCodeUtil.a(2131706967));
    this.vg.setLeftButton(HardCodeUtil.a(2131706968));
    ((Button)this.mContentView.findViewById(2131370349)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131376444)).setOnClickListener(this);
    ((Button)this.mContentView.findViewById(2131365083)).setOnClickListener(this);
    this.mContentView.findViewById(2131376381).setOnClickListener(this);
    this.mContentView.findViewById(2131374732).setOnClickListener(this);
    this.mContentView.findViewById(2131378979).setOnClickListener(this);
    this.mContentView.findViewById(2131366367).setOnClickListener(this);
    this.mContentView.findViewById(2131373971).setOnClickListener(this);
    this.mContentView.findViewById(2131365376).setOnClickListener(this);
    this.mContentView.findViewById(2131364675).setOnClickListener(this);
    this.mContentView.findViewById(2131364673).setOnClickListener(this);
    this.mContentView.findViewById(2131365255).setOnClickListener(this);
    this.mContentView.findViewById(2131377832).setOnClickListener(this);
    this.mContentView.findViewById(2131365084).setOnClickListener(this);
    this.mContentView.findViewById(2131365088).setOnClickListener(this);
    this.mContentView.findViewById(2131368323).setOnClickListener(this);
    this.mContentView.findViewById(2131366252).setOnClickListener(this);
    this.mContentView.findViewById(2131377248).setOnClickListener(this);
    this.mContentView.findViewById(2131376443).setOnClickListener(this);
    this.mContentView.findViewById(2131376442).setOnClickListener(this);
    this.mContentView.findViewById(2131380287).setOnClickListener(this);
    this.mContentView.findViewById(2131380286).setOnClickListener(this);
    this.mContentView.findViewById(2131377249).setOnClickListener(this);
    this.mContentView.findViewById(2131371540).setOnClickListener(this);
    this.mContentView.findViewById(2131371550).setOnClickListener(this);
    this.mContentView.findViewById(2131380283).setOnClickListener(this);
    paramLayoutInflater = (TextView)this.mContentView.findViewById(2131377248);
    paramViewGroup = (TextView)this.mContentView.findViewById(2131377249);
    ((EditText)this.mContentView.findViewById(2131368887)).addTextChangedListener(new MsgBackupSettingFragment.1(this, paramLayoutInflater, paramViewGroup));
    paramLayoutInflater.setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { "10000" }));
    paramViewGroup.setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { "1000" }));
    paramViewGroup = PreferenceManager.getDefaultGlobalPreference(getBaseActivity());
    paramBundle = paramViewGroup.getString("msgbackup_uin", "");
    String str1 = paramViewGroup.getString("msgbackup_picfilepath", "");
    String str2 = paramViewGroup.getString("msgbackup_inputcount", "");
    String str3 = paramViewGroup.getString("msgbackup_isNeedGeneratedStr", "");
    if (!TextUtils.isEmpty(paramBundle))
    {
      int i = paramViewGroup.getInt("msgbackup_uintype", 0);
      ((EditText)this.mContentView.findViewById(2131366368)).setText(paramBundle);
      ((EditText)this.mContentView.findViewById(2131366369)).setText(String.valueOf(i));
      ((EditText)this.mContentView.findViewById(2131366817)).setText(str1);
      ((EditText)this.mContentView.findViewById(2131368887)).setText(str2);
      ((EditText)this.mContentView.findViewById(2131368964)).setText(str3);
    }
    paramLayoutInflater.requestFocus();
    this.jdField_b_of_type_ArrayOfJavaLangString = a();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), new MsgBackupSettingFragment.2(this));
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), new MsgBackupSettingFragment.3(this));
  }
  
  protected int getContentLayoutId()
  {
    return 2131561458;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    Object localObject1 = ((EditText)this.mContentView.findViewById(2131366368)).getText().toString();
    Object localObject5 = ((EditText)this.mContentView.findViewById(2131366369)).getText().toString();
    Object localObject3 = ((EditText)this.mContentView.findViewById(2131368887)).getText().toString();
    Object localObject2 = ((EditText)this.mContentView.findViewById(2131366817)).getText().toString();
    Object localObject4 = ((EditText)this.mContentView.findViewById(2131368964)).getText().toString();
    boolean bool = "1".equals(localObject4);
    int m = 0;
    int k = 0;
    try
    {
      j = Integer.parseInt((String)localObject5);
    }
    catch (Exception localException1)
    {
      int j;
      label136:
      break label136;
    }
    j = 0;
    try
    {
      i = Integer.parseInt((String)localObject3);
    }
    catch (Exception localException2)
    {
      int i;
      label147:
      ArrayList localArrayList;
      break label147;
    }
    i = 0;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      j = jdField_a_of_type_Int;
    }
    else
    {
      jdField_a_of_type_JavaLangString = (String)localObject1;
      jdField_a_of_type_Int = j;
      localObject5 = PreferenceManager.getDefaultGlobalPreference(getBaseActivity());
      ((SharedPreferences)localObject5).edit().putString("msgbackup_uin", (String)localObject1).apply();
      ((SharedPreferences)localObject5).edit().putInt("msgbackup_uintype", j).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_picfilepath", (String)localObject2).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_inputcount", (String)localObject3).apply();
      ((SharedPreferences)localObject5).edit().putString("msgbackup_isNeedGeneratedStr", (String)localObject4).apply();
    }
    localObject3 = MsgBackupManager.a();
    localObject4 = (MsgBackupAuthHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER);
    localObject5 = new MsgBackupUserData.Builder();
    localArrayList = new ArrayList(2);
    switch (n)
    {
    default: 
      break;
    case 2131380287: 
      this.jdField_c_of_type_JavaLangString = Uri.encode("111111111111111111");
      MsgBackupUtil.a("IphoneTitleBarFragment", "编码之后的value = %s", new Object[] { this.jdField_c_of_type_JavaLangString });
      break;
    case 2131380286: 
      localObject1 = this.jdField_c_of_type_JavaLangString;
      if (localObject1 != null) {
        MsgBackupUtil.a("IphoneTitleBarFragment", "解码之后的value = %s", new Object[] { Uri.decode((String)localObject1) });
      }
      break;
    case 2131380283: 
      c();
      localObject1 = MsgBackupUtil.a("http://10.71.161.35:8001/4EFF91728050FE643749C167C73EBCDA6CD8EE193B8636D01B445730BB8A31EE1374186F5611658FD9217AB6FF9BC857DE9D9A8DFA5CFF3C8E063D3B2FA3BB0B1B0EDC7D8B162F850C0A375A45E4CE3B70846A812C626CB5ED09EB107556EECB765BCF39A41BACA755747BE723749A26655D46D004D3DBA34C374CA622B8B0F3E3B2F0E582BA37B4", "10.71.161.35", 8001, "'U}MXig2f9zi:$?_");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RESULT = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("MsgBackupSettingFragment", 1, ((StringBuilder)localObject2).toString());
      break;
    case 2131378979: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupConfirmQrRsp;
      if (localObject1 != null) {
        ((MsgBackupAuthHandler)localObject4).a(((MsgBackupConfirmQrRsp)localObject1).a());
      } else {
        QLog.d("MsgBackup", 1, "case tokenConfirm qrConfirmReponse is null!");
      }
      break;
    case 2131377832: 
      d();
      break;
    case 2131377249: 
      a((String)localObject1, j, (String)localObject2, i, bool);
      break;
    case 2131377248: 
      localObject2 = new SessionInfo();
      ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((SessionInfo)localObject2).jdField_a_of_type_Int = j;
      j = k;
      if (i > 0) {
        j = i;
      }
      ThreadManager.newFreeThread(new MsgBackupSettingFragment.4(this, j, (SessionInfo)localObject2), "msgbackup_testSendMsg", 1).start();
      break;
    case 2131377246: 
      a((String)localObject1, j, (String)localObject2, i);
      break;
    case 2131376444: 
      if ((this.jdField_b_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_a_of_type_JavaLangInteger.intValue() != 0))
      {
        QQToast.a(getBaseActivity(), -1, HardCodeUtil.a(2131706966), 1).a();
        ((MsgBackupUserData.Builder)localObject5).c(this.jdField_b_of_type_ArrayOfJavaLangString[1]);
        ((MsgBackupUserData.Builder)localObject5).b(this.jdField_b_of_type_ArrayOfJavaLangString[0]);
        ((MsgBackupUserData.Builder)localObject5).a(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
        localArrayList.add(this.jdField_b_of_type_JavaLangInteger);
        localArrayList.add(this.jdField_a_of_type_JavaLangInteger);
        ((MsgBackupUserData.Builder)localObject5).a(localArrayList);
        ((MsgBackupUserData.Builder)localObject5).a(4);
        ((MsgBackupAuthHandler)localObject4).a(((MsgBackupUserData.Builder)localObject5).a(), 3, false);
      }
      break;
    case 2131376443: 
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthHandler.a();
      break;
    case 2131376442: 
      if (!TextUtils.isEmpty(MsgBackupManager.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthHandler.b(MsgBackupManager.jdField_a_of_type_JavaLangString);
      }
      break;
    case 2131376381: 
      localObject1 = jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp;
      if (localObject1 != null) {
        ((MsgBackupAuthHandler)localObject4).a(((MsgBackupGetQrRsp)localObject1).a(), 3);
      } else {
        QLog.d("MsgBackup", 1, "case rejectQR qrResponse is null!");
      }
      break;
    case 2131374732: 
      localObject1 = jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp;
      if (localObject1 != null) {
        ((MsgBackupAuthHandler)localObject4).c(((MsgBackupGetQrRsp)localObject1).a());
      } else {
        QLog.d("MsgBackup", 1, "case queryQRState qrResponse is null!");
      }
      break;
    case 2131371550: 
      k = m;
      if (i > 0) {
        k = i;
      }
      localObject2 = MsgbackupMsgGenerator.a(null, k, (String)localObject1, j, getBaseActivity().app.getCurrentUin());
      if (((List)localObject2).size() > 0) {
        MsgbackupMsgGenerator.a(getBaseActivity().app, (List)localObject2);
      }
      localObject1 = MessageRecord.getTableName((String)localObject1, j);
      i = getBaseActivity().app.getMessageFacade().a((String)localObject1, 0L, 9223372036854775807L, false);
      localObject1 = (TextView)getBaseActivity().findViewById(2131371549);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("result:msgSize =  ");
      ((StringBuilder)localObject2).append(i);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      break;
    case 2131371540: 
      MsgbackupMsgGenerator.a(getBaseActivity().app);
      break;
    case 2131370349: 
      c();
      break;
    case 2131368323: 
      QQToast.a(getBaseActivity(), -1, HardCodeUtil.a(2131706962), 1).a();
      break;
    case 2131366367: 
      ((MsgBackupManager)localObject3).jdField_a_of_type_JavaUtilHashSet.clear();
      getBaseActivity().app.getProxyManager().a();
      localObject1 = RecentDataListManager.a((String)localObject1, j);
      localObject1 = RecentDataListManager.a().a((String)localObject1);
      if (localObject1 != null)
      {
        ((MsgBackupManager)localObject3).jdField_a_of_type_JavaUtilHashSet.add(localObject1);
        localObject1 = new MsgBackupRequest();
        ((MsgBackupRequest)localObject1).jdField_a_of_type_JavaUtilHashSet = MsgBackupManager.a().jdField_a_of_type_JavaUtilHashSet;
        ((MsgBackupRequest)localObject1).jdField_a_of_type_Int = 0;
        ((MsgBackupManager)localObject3).a((MsgBackupRequest)localObject1);
      }
      else
      {
        QLog.d("MsgBackup", 1, "test export submit,recentBaseData is null");
      }
      break;
    case 2131366252: 
      localObject1 = MsgBackupJniProxy.encryptFromString("i am a hero!!!", "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131706970), new Object[] { "i am a hero!!!", localObject1 });
      localObject2 = MsgBackupJniProxy.decryptFromString((String)localObject1, "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131706954), new Object[] { localObject1, localObject2 });
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
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131706956), new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(localObject1.length) });
      localObject2 = MsgBackupJniProxy.decryptFromByteArray((byte[])localObject1, "1111111111111111");
      MsgBackupUtil.a("MsgBackup", HardCodeUtil.a(2131706941), new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(localObject2.length) });
      break;
    case 2131365376: 
      MsgBackupManager.a().c(null);
      break;
    case 2131365255: 
      a();
      break;
    case 2131365088: 
      a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupPushData);
      break;
    case 2131365084: 
      a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupPushData);
      break;
    case 2131365083: 
      if ((this.jdField_b_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_a_of_type_JavaLangInteger.intValue() != 0))
      {
        QQToast.a(getBaseActivity(), -1, HardCodeUtil.a(2131706963), 1).a();
        if (jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp != null)
        {
          ((MsgBackupUserData.Builder)localObject5).c(this.jdField_b_of_type_ArrayOfJavaLangString[1]);
          ((MsgBackupUserData.Builder)localObject5).b(this.jdField_b_of_type_ArrayOfJavaLangString[0]);
          ((MsgBackupUserData.Builder)localObject5).a(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
          localArrayList.add(this.jdField_b_of_type_JavaLangInteger);
          localArrayList.add(this.jdField_a_of_type_JavaLangInteger);
          ((MsgBackupUserData.Builder)localObject5).a(localArrayList);
          ((MsgBackupUserData.Builder)localObject5).a(4);
          ((MsgBackupAuthHandler)localObject4).a(((MsgBackupUserData.Builder)localObject5).a(), jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp.a(), 3);
        }
        else
        {
          QLog.d("MsgBackup", 1, "case confirmQR qrResponse is null!");
        }
      }
      break;
    case 2131364675: 
      getBaseActivity().app.getMessageFacade().a((String)localObject1, j);
      break;
    case 2131364673: 
      ((MsgBackupManager)localObject3).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    if (getBaseActivity() != null) {
      getBaseActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment
 * JD-Core Version:    0.7.0.1
 */