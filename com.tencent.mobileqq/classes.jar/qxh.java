import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1;
import com.tencent.qphone.base.util.QLog;

public class qxh
  implements qxr
{
  public qxh(RIJUgcImageUploader.1 param1) {}
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    qxg.a(this.a.this$0).a(paramFloat);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i(qxg.a, 2, "uploadImage finish, url=" + paramString1);
    }
    qxg.a(this.a.this$0, false);
    if (paramInt == 0)
    {
      QLog.i(qxg.a, 1, "uploadImage success");
      qxg.a(this.a.this$0).a(paramString1);
    }
    for (;;)
    {
      qxg.a(this.a.this$0).b();
      return;
      QLog.i(qxg.a, 1, "uploadImage failed, errCode=" + paramInt);
      qxg.a(this.a.this$0).a(paramInt, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxh
 * JD-Core Version:    0.7.0.1
 */