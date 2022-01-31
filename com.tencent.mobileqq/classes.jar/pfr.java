import com.tencent.biz.webviewplugin.ARMapPlugin;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class pfr
  extends SosoInterface.OnLocationListener
{
  public pfr(ARMapPlugin paramARMapPlugin, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    long l1 = 0L;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      try
      {
        long l2 = Long.valueOf(paramSosoLbsInfo.a.f).longValue();
        l1 = l2;
        i = paramInt;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            String str1;
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("result", String.valueOf(i));
            localJSONObject1.put("code", String.valueOf(paramInt));
            localJSONObject1.put("msg", "");
            if (i != 0) {
              continue;
            }
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("adcode", String.valueOf(l1));
            localJSONObject2.put("shen", str1);
            localJSONObject2.put("shi", str3);
            localJSONObject2.put("qu", paramSosoLbsInfo);
            localJSONObject1.put("data", localJSONObject2);
            paramSosoLbsInfo = localJSONObject1.toString();
            if (QLog.isColorLevel()) {
              QLog.d("ARMapPlugin", 2, "getLbsInfo callback=" + this.jdField_a_of_type_JavaLangString + ", json=" + paramSosoLbsInfo);
            }
            this.jdField_a_of_type_ComTencentBizWebviewpluginARMapPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramSosoLbsInfo });
            return;
          }
          catch (Exception paramSosoLbsInfo)
          {
            int i;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ARMapPlugin", 2, "getLbsInfo exception", paramSosoLbsInfo);
            paramSosoLbsInfo.printStackTrace();
            return;
          }
          localException = localException;
          if (QLog.isColorLevel()) {
            QLog.d("ARMapPlugin", 2, "getLbsInfo exception", localException);
          }
          i = -10;
        }
      }
      if (paramSosoLbsInfo.a.d == null) {
        break label454;
      }
    }
    String str2;
    label454:
    for (str1 = paramSosoLbsInfo.a.d;; str2 = "")
    {
      if (paramSosoLbsInfo.a.e != null) {}
      for (String str3 = paramSosoLbsInfo.a.e;; str3 = "")
      {
        if (paramSosoLbsInfo.a.g != null) {
          paramSosoLbsInfo = paramSosoLbsInfo.a.g;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARMapPlugin", 2, "getLbsInfo result=" + i + ", sheng=" + str1 + ",shi=" + str3 + ", qu=" + paramSosoLbsInfo + ", adCode=" + l1);
          }
          for (;;)
          {
            JSONObject localJSONObject1;
            JSONObject localJSONObject2;
            QLog.d("ARMapPlugin", 1, "getLbsInfo  onLocationFinish,failed errCode:" + paramInt);
            i = paramInt;
            paramSosoLbsInfo = "";
            str2 = "";
            str3 = "";
            break;
            localJSONObject1.put("data", "");
          }
          paramSosoLbsInfo = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfr
 * JD-Core Version:    0.7.0.1
 */