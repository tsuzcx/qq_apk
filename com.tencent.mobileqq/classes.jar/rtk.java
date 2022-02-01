import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;

class rtk
  extends sbh
{
  rtk(rsx paramrsx) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!bhnv.g(rsx.a(this.a)))
    {
      QQToast.a(rsx.a(this.a), 0, anzj.a(2131714978), 0).a();
      return;
    }
    rpt.a(rsx.a(this.a), rsx.a(this.a));
    paramVideoInfo.e = true;
    rsx.a(this.a).b(rsx.b(this.a));
    if ((rsx.a(this.a) instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)rsx.a(this.a)).d(true);
    }
    paramString = paramVideoInfo.k;
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putInt("videoDuration", paramVideoInfo.jdField_d_of_type_Int);
    long l;
    if (TextUtils.isEmpty(paramVideoInfo.j))
    {
      l = 0L;
      paramActionSheetItem.putLong("publishAccountUin", l);
      paramActionSheetItem.putString("publishAccountName", paramString);
      paramActionSheetItem.putLong("feedsId", paramVideoInfo.jdField_d_of_type_Long);
      paramActionSheetItem.putInt("feedsType", paramVideoInfo.h);
      if (paramVideoInfo.a != 6) {
        break label289;
      }
      paramInt = 1;
      label189:
      paramActionSheetItem.putInt("videoType", paramInt);
      if (paramVideoInfo.g != null) {
        break label294;
      }
    }
    label289:
    label294:
    for (paramString = "";; paramString = paramVideoInfo.g)
    {
      pnx.a().a(rsx.a(this.a), rsx.a(this.a).c(), 2, paramString, paramVideoInfo.c, paramVideoInfo.jdField_d_of_type_JavaLangString, paramVideoInfo.b, paramVideoInfo.f + "&sourcefrom=6", paramActionSheetItem);
      paramVideoInfo.jdField_d_of_type_Boolean = true;
      return;
      l = Long.valueOf(paramVideoInfo.j).longValue();
      break;
      paramInt = 2;
      break label189;
    }
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtk
 * JD-Core Version:    0.7.0.1
 */