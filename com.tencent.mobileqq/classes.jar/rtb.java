import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadController.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class rtb
  extends pvq
{
  rtb(rta paramrta) {}
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.a.c = false;
    QLog.d("ReadInJoyDeliverVideo", 1, "receive 83e requestUUID:" + paramString1 + " ,retCode :" + paramInt1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(rta.a(this.a))) || (!paramString1.equals(rta.a(this.a)))) {
      return;
    }
    if (paramInt1 == 0)
    {
      rsz.b(rta.a(this.a));
      this.a.b = true;
      if (rta.a(this.a)) {
        ThreadManager.post(new KandianVideoUploadController.1.1(this), 5, null, false);
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          if (TextUtils.isEmpty(paramString3))
          {
            paramString1 = "";
            str = paramString1;
          }
        }
        catch (Exception paramString1)
        {
          Object localObject;
          String str;
          label369:
          continue;
        }
        try
        {
          ((JSONObject)localObject).put("type", 4);
          str = paramString1;
          rta.a(this.a, rta.a(this.a).getLong("arg_video_duration", 0L));
          str = paramString1;
          rta.a(this.a, rta.a(this.a).getInt("arg_video_width", 0));
          str = paramString1;
          ((JSONObject)localObject).put("comment", new String(bhcu.encode(paramString1.getBytes(), 0)));
          str = paramString1;
          ((JSONObject)localObject).put("feedsId", String.valueOf(paramLong));
          str = paramString1;
          ((JSONObject)localObject).put("status", paramInt2);
          str = paramString1;
          ((JSONObject)localObject).put("ugcVideoCoverUrl", rta.b(this.a));
          str = paramString1;
          ((JSONObject)localObject).put("ugcVideoDuration", rta.a(this.a));
          str = paramString1;
          ((JSONObject)localObject).put("ugcVideoRowkey", paramString2);
          str = paramString1;
          ((JSONObject)localObject).put("ugcVideoWidth", rta.a(this.a));
          str = paramString1;
          ((JSONObject)localObject).put("ugcVideoHeight", rta.b(this.a));
          str = paramString1;
          if (rta.c(this.a) != 12) {
            continue;
          }
          str = paramString1;
          ((JSONObject)localObject).put("feedsType", 4);
          str = paramString1;
          localObject = ((JSONObject)localObject).toString();
          str = paramString1;
          rta.a(this.a).putString("arg_result_json", (String)localObject);
          paramString3 = paramString1;
          str = paramString1;
          if (QLog.isColorLevel())
          {
            str = paramString1;
            QLog.d("ReadInJoyDeliverVideo", 2, "onDeliverUpMasterResult resultJson=" + (String)localObject);
            paramString3 = paramString1;
          }
        }
        catch (Exception paramString1)
        {
          paramString3 = str;
        }
      }
      this.a.a(0);
      bmhv.B(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      paramString1 = paramString3;
    }
    for (;;)
    {
      if (rta.a(this.a) != null) {
        rta.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, paramInt1, paramLong, paramString2, paramInt2, paramString1, paramString4);
      }
      rta.a(this.a, paramInt1);
      rta.b(this.a, paramInt1);
      return;
      ((JSONObject)localObject).put("type", 5);
      paramString1 = paramString3;
      break;
      str = paramString1;
      if (rta.c(this.a) != 13) {
        break label369;
      }
      str = paramString1;
      ((JSONObject)localObject).put("feedsType", 5);
      break label369;
      if (paramInt1 == 33)
      {
        this.a.a(1006);
        paramString1 = paramString3;
      }
      else
      {
        this.a.a(1006);
        paramString1 = paramString3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtb
 * JD-Core Version:    0.7.0.1
 */