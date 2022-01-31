import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils.PhotoCollectionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mwx
  extends PublicAccountArticleObserver
{
  public mwx(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void a(PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond");
    }
    PublicAccountImageCollectionMainActivity.a(this.a, paramPhotoCollectionInfo);
    if (paramPhotoCollectionInfo == null)
    {
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxe(this), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivity.a(this.a, paramPhotoCollectionInfo);
    PublicAccountImageCollectionMainActivity.a(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onReportReadPhotoCollectionRespond isSuccess =" + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCreateArticleCommentRespond isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      PublicAccountImageCollectionMainActivity.b(this.a);
    }
    for (int i = 1;; i = 0)
    {
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxf(this, paramBoolean, paramInt), 0L);
      PublicAccountReportUtils.a(null, this.a.jdField_a_of_type_JavaLangString, "0X8007B97", "0X8007B97", 0, 0, this.a.b, this.a.c, "" + i, "", false);
      return;
    }
  }
  
  public void a(boolean paramBoolean, PublicAccountImageCollectionUtils.PhotoCollectionInfo paramPhotoCollectionInfo, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      if ((paramString != null) && (!paramString.equals(this.a.b)))
      {
        if (paramPhotoCollectionInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramPhotoCollectionInfo.jdField_a_of_type_JavaLangString);
          }
          PublicAccountImageCollectionPreloadManager.a().a(paramPhotoCollectionInfo, paramArrayOfByte);
          PublicAccountImageCollectionPreloadManager.a().b(paramPhotoCollectionInfo);
        }
        if ((paramPhotoCollectionInfo == null) || (paramPhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList == null)) {
          break label308;
        }
      }
    }
    label308:
    for (int i = paramPhotoCollectionInfo.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      PublicAccountReportUtils.a(null, this.a.jdField_a_of_type_JavaLangString, "0X8007B8A", "0X8007B8A", 0, 0, this.a.b, this.a.c, "" + PublicAccountImageCollectionMainActivity.b(this.a, PublicAccountImageCollectionMainActivity.a(this.a)), "" + i, false);
      return;
      PublicAccountImageCollectionMainActivity.a(this.a, paramPhotoCollectionInfo);
      if (paramPhotoCollectionInfo == null)
      {
        PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxc(this), 0L);
        break;
      }
      PublicAccountImageCollectionMainActivity.a(this.a, paramPhotoCollectionInfo);
      PublicAccountImageCollectionPreloadManager.a().a(paramPhotoCollectionInfo, paramArrayOfByte);
      PublicAccountImageCollectionMainActivity.a(this.a);
      break;
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxd(this), 0L);
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onSendArticleLikeReq,articleID=" + paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onQueryArticleLikeCount,articleID=" + paramString + "likeCount" + paramInt);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.b)))
    {
      PublicAccountImageCollectionMainActivity.a(this.a, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mwy(this, paramInt), 0L);
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCheckIsArticleLiked,articleID=" + paramString + "isLiked" + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.b)))
    {
      PublicAccountImageCollectionMainActivity.a(this.a, paramBoolean2);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxb(this), 0L);
    }
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetRecommendInfoRespond isSuccess =" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxh(this), 0L);
        return;
      }
      PublicAccountImageCollectionMainActivity.a(this.a, paramArrayList);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxi(this, paramArrayList), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mwz(this), 0L);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetArticleCommentCountRespond count=" + paramInt);
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivity.c(this.a, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxg(this), 0L);
    }
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetArticleReadCount isSuccess =" + paramBoolean);
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivity.d(this.a, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new mxa(this), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwx
 * JD-Core Version:    0.7.0.1
 */