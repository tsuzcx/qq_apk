import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;

class phs
  implements pen
{
  phs(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    paramView = (articlesummary.ChannelInfo)paramView.getTag();
    if (paramView != null)
    {
      if ((!paramView.bytes_channel_url.has()) || (paramView.bytes_channel_url.get() == null)) {
        break label75;
      }
      if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
        pay.a(phl.a(this.a).a().a(), paramView.bytes_channel_url.get().toStringUtf8());
      }
    }
    return;
    label75:
    okj.b(phl.a(this.a).a().a(), paramView.uint32_channel_id.get(), pay.a(paramView), paramView.uint32_channel_type.get(), 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phs
 * JD-Core Version:    0.7.0.1
 */