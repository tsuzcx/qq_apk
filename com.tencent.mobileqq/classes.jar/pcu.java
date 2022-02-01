import android.text.Editable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import java.util.UUID;
import org.json.JSONObject;

public class pcu
  implements QQPublishCommentBridge
{
  private final pdl a;
  
  public pcu(pdl parampdl)
  {
    this.a = parampdl;
  }
  
  public JSONObject buildArticleBiuCommentInfo(Editable paramEditable)
  {
    return new pcw(this, null).a(paramEditable);
  }
  
  public TkdQQArgument getArgument()
  {
    return this.a.a;
  }
  
  public String getCommentString(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() <= 0)) {
      paramEditable = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPublishBridgeImpl", 2, "getCommentString result=" + paramEditable);
      }
      return paramEditable;
      String str = UUID.randomUUID().toString();
      paramEditable = rvy.a(paramEditable.toString(), str).trim();
      if (paramEditable.length() <= 0) {
        paramEditable = "";
      } else {
        paramEditable = bcsc.a(rvy.b(paramEditable.replaceAll("\n|\r\n", ""), str));
      }
    }
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
  }
  
  public void showToast(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), paramInt2, paramString, paramInt1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcu
 * JD-Core Version:    0.7.0.1
 */