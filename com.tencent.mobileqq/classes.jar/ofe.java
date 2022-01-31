import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.util.MqqWeakReferenceHandler;

public class ofe
  implements EncodeVideoTask.ResultListener
{
  public ofe(EditWebVideoActivity paramEditWebVideoActivity) {}
  
  public void a(int paramInt)
  {
    this.a.runOnUiThread(new off(this));
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = ((EditWebVideoPartManager)this.a.a).a;
    EditWebVideoActivity.a(this.a, paramString1);
    EditWebVideoActivity.a(this.a, paramArrayOfByte1);
    EditWebVideoActivity.b(this.a, HexUtil.bytes2HexStr(EditWebVideoActivity.a(this.a)));
    paramString1 = this.a;
    if (i <= 0) {}
    for (;;)
    {
      EditWebVideoActivity.a(paramString1, paramInt3);
      EditWebVideoActivity.c(this.a, paramString2);
      EditWebVideoActivity.b(this.a, paramArrayOfByte2);
      EditWebVideoActivity.b(this.a, paramInt1);
      EditWebVideoActivity.c(this.a, paramInt2);
      EditWebVideoActivity.a(this.a).sendEmptyMessage(1002);
      return;
      paramInt3 = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofe
 * JD-Core Version:    0.7.0.1
 */