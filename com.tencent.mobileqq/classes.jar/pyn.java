import com.qq.taf.jce.HexUtil;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;

public class pyn
  implements EncodeVideoTask.ResultListener
{
  public pyn(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (DevLittleVideoItemBuilder.a(this.a) != null)
    {
      DevLittleVideoItemBuilder.a(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, DevLittleVideoItemBuilder.a(this.a), paramString1, this.a).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pyn
 * JD-Core Version:    0.7.0.1
 */