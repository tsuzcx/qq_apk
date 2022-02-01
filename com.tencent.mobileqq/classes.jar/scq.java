import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;

class scq
  extends skd
{
  scq(sce paramsce) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!bgnt.g(sce.a(this.a)))
    {
      QQToast.a(sce.a(this.a), 0, anni.a(2131714869), 0).a();
      return;
    }
    ryx.a(sce.a(this.a), sce.a(this.a));
    paramVideoInfo.e = true;
    sce.a(this.a).a(sce.b(this.a));
    if ((sce.a(this.a) instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)sce.a(this.a)).d(true);
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
      pvl.a().a(sce.a(this.a), sce.a(this.a).c(), 2, paramString, paramVideoInfo.c, paramVideoInfo.jdField_d_of_type_JavaLangString, paramVideoInfo.b, paramVideoInfo.f + "&sourcefrom=6", paramActionSheetItem);
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
 * Qualified Name:     scq
 * JD-Core Version:    0.7.0.1
 */