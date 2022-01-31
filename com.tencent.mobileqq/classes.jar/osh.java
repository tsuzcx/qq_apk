import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ac.ArticleCenter.GetVidByUrlResponse;
import com.tencent.mobileqq.ac.ArticleCenter.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class osh
  implements BusinessObserver
{
  osh(osf paramosf, long paramLong, NewIntent paramNewIntent, osj paramosj, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID time : " + (l1 - l2));
    }
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Osj != null) {
        this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_JavaLangString, "error");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID notSuccess!");
      }
    }
    label299:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramBundle = paramBundle.getByteArray("data");
            if ((paramBundle == null) || (paramBundle.length <= 0))
            {
              if (this.jdField_a_of_type_Osj != null) {
                this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_JavaLangString, "error");
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID empty data!");
              }
            }
            else
            {
              try
              {
                localObject = new ArticleCenter.GetVidByUrlResponse();
                ((ArticleCenter.GetVidByUrlResponse)localObject).mergeFrom(paramBundle);
                if (((ArticleCenter.GetVidByUrlResponse)localObject).ret_info.ret_code.get() == 0) {
                  break label299;
                }
                if (this.jdField_a_of_type_Osj != null) {
                  this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_JavaLangString, "error");
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID error:" + ((ArticleCenter.GetVidByUrlResponse)localObject).ret_info.ret_code.get() + ", " + ((ArticleCenter.GetVidByUrlResponse)localObject).ret_info.err_info.get());
                  return;
                }
              }
              catch (Exception paramBundle)
              {
                if (this.jdField_a_of_type_Osj != null) {
                  this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_JavaLangString, "error");
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID exception!");
        return;
        paramBundle = ((ArticleCenter.GetVidByUrlResponse)localObject).vid.get();
        if (paramBundle == null) {
          break;
        }
        Object localObject = paramBundle.toStringUtf8();
        paramBundle = (Bundle)localObject;
        if (this.jdField_a_of_type_Osj != null)
        {
          paramBundle = (Bundle)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramBundle = "error";
          }
          this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_JavaLangString, paramBundle);
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID vid:" + paramBundle);
      return;
      if (this.jdField_a_of_type_Osj != null) {
        this.jdField_a_of_type_Osj.a(this.jdField_a_of_type_JavaLangString, "error");
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.TAG", 2, "CMD_VIDEO_URLFORUUID null vid!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     osh
 * JD-Core Version:    0.7.0.1
 */