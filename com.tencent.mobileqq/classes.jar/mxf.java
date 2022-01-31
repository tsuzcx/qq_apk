import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class mxf
{
  public static void a(AppInterface paramAppInterface, mxg parammxg, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppInterface == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(paramAppInterface.getApp(), mxe.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (parammxg != null)
    {
      parammxg.a = new WeakReference(paramAppInterface);
      parammxg.jdField_b_of_type_Int = 1;
      paramArrayOfByte.setObserver(parammxg);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    a(paramAppInterface, paramArrayOfByte, paramInt, paramString, null, false);
  }
  
  public static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte, int paramInt, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.getApp(), mxe.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", paramBoolean);
    localNewIntent.putExtra("RequestType", paramInt);
    localNewIntent.putExtra("DataType", 2);
    paramAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxh parammxh, byte[] paramArrayOfByte, String paramString)
  {
    a(paramQQAppInterface, parammxh, paramArrayOfByte, paramString, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxh parammxh, byte[] paramArrayOfByte, String paramString, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), mxe.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    parammxh.a = new WeakReference(paramQQAppInterface);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(parammxh);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString)
  {
    a(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, paramInt1, paramInt2, null, 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    b(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, Bundle paramBundle)
  {
    a(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, paramBundle, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), mxe.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    parammxj.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    parammxj.jdField_b_of_type_Int = 2;
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", paramBoolean);
    localNewIntent.setObserver(parammxj);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(BaseApplicationImpl.getContext(), mxe.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (parammxj != null)
    {
      parammxj.jdField_b_of_type_Int = 1;
      paramArrayOfByte.setObserver(parammxj);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    b(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, paramInt1, paramInt2, null, 0L);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    b(paramQQAppInterface, parammxj, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, 0L);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, mxj parammxj, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(paramQQAppInterface.getApp(), mxe.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (parammxj != null)
    {
      parammxj.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
      parammxj.jdField_b_of_type_Int = 1;
      paramArrayOfByte.setObserver(parammxj);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramQQAppInterface.startServlet(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxf
 * JD-Core Version:    0.7.0.1
 */