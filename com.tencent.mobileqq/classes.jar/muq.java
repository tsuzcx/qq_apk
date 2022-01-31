import android.text.TextUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class muq
  implements ITransactionCallback
{
  long jdField_a_of_type_Long = 0L;
  
  muq(mup parammup, String paramString, long paramLong, byte[] paramArrayOfByte, mur parammur) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.w(this.jdField_a_of_type_Mup.jdField_a_of_type_JavaLangString, 1, "onFailed, sessionId[" + this.jdField_a_of_type_JavaLangString + "], retCode[" + paramInt + "]");
    paramArrayOfByte = bbea.a(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_a_of_type_Mur.a(paramInt, this.jdField_a_of_type_JavaLangString, "", paramArrayOfByte);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str2 = "";
    String str1;
    if (paramArrayOfByte != null) {
      str1 = str2;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new Bdh_extinfo.CommFileExtRsp();
        str1 = str2;
        ((Bdh_extinfo.CommFileExtRsp)localObject2).mergeFrom(paramArrayOfByte);
        str1 = str2;
        str2 = ((Bdh_extinfo.CommFileExtRsp)localObject2).bytes_download_url.get().toStringUtf8();
        str1 = str2;
        boolean bool = TextUtils.isEmpty(str2);
        if (!bool) {
          continue;
        }
        i = -10010;
        str1 = str2;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        i = -10012;
        continue;
        paramArrayOfByte = null;
        continue;
      }
      str2 = bbea.a(this.jdField_a_of_type_ArrayOfByte);
      localObject2 = this.jdField_a_of_type_Mup.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("onSuccess, sessionId[").append(this.jdField_a_of_type_JavaLangString).append("], respData[");
      Object localObject1;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
        QLog.w((String)localObject2, 1, paramArrayOfByte + "], retCode[" + i + "], md5[" + str2 + "], url[" + str1 + "]");
        AudioHelper.a(this.jdField_a_of_type_Mup.jdField_a_of_type_JavaLangString, paramHashMap, false);
        this.jdField_a_of_type_Mur.a(i, this.jdField_a_of_type_JavaLangString, str1, str2);
        return;
        try
        {
          if (QLog.isDevelopLevel()) {
            QLog.w(this.jdField_a_of_type_Mup.jdField_a_of_type_JavaLangString, 1, "onSuccess, sessionId[" + this.jdField_a_of_type_JavaLangString + "], 原始url[" + str2 + "]");
          }
          str1 = bfnx.a(str2);
          i = 0;
        }
        catch (Exception localException1)
        {
          i = -10011;
          localObject1 = str2;
        }
      }
      else
      {
        i = 0;
        localObject1 = localException2;
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    QLog.w(this.jdField_a_of_type_Mup.jdField_a_of_type_JavaLangString, 1, "onTransStart, sessionId[" + this.jdField_a_of_type_JavaLangString + "]");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long < l)
      {
        QLog.w(this.jdField_a_of_type_Mup.jdField_a_of_type_JavaLangString, 1, "onUpdateProgress, sessionId[" + this.jdField_a_of_type_JavaLangString + "], transferedSize[" + paramInt + "], totalSize[" + this.b + "]");
        this.jdField_a_of_type_Long = (l + 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     muq
 * JD-Core Version:    0.7.0.1
 */