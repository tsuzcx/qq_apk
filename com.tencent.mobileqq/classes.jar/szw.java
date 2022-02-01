import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class szw
  extends qeg
{
  public szw(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if ((ReadInJoyFastWebBottomSocialView.a(this.a) == null) || (ReadInJoyFastWebBottomSocialView.a(this.a) == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleDoFavoriteResult but articleInfo is null.");
      return;
    }
    QQToast localQQToast;
    if ((paramBoolean) && (ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID.equals(paramString1)))
    {
      localQQToast = new QQToast(ReadInJoyFastWebBottomSocialView.a(this.a));
      localQQToast.d(2000);
      localQQToast.b(2);
      localQQToast.a(QQToast.a(2));
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleDoFavoriteResult,operationType=" + paramInt + ",button status:" + ReadInJoyFastWebBottomSocialView.b(this.a).isSelected());
      if (paramInt != 1) {
        break label319;
      }
      ArrayList localArrayList = (ArrayList)ReadInJoyFastWebBottomSocialView.a(this.a).get(ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID);
      paramString1 = localArrayList;
      if (localArrayList == null) {
        paramString1 = new ArrayList();
      }
      paramString1.add(paramString2);
      ReadInJoyFastWebBottomSocialView.a(this.a).put(ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID, paramString1);
      if (!ReadInJoyFastWebBottomSocialView.b(this.a).isSelected()) {
        break label308;
      }
      localQQToast.a(ReadInJoyFastWebBottomSocialView.a);
      ReadInJoyFastWebBottomSocialView.b(this.a, true);
      localQQToast.a();
    }
    for (;;)
    {
      ReadInJoyFastWebBottomSocialView.a(this.a, false);
      return;
      label308:
      ReadInJoyFastWebBottomSocialView.c(this.a, false);
      continue;
      label319:
      if (paramInt == 2)
      {
        ReadInJoyFastWebBottomSocialView.a(this.a).remove(ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID);
        if (!ReadInJoyFastWebBottomSocialView.b(this.a).isSelected())
        {
          localQQToast.a(ReadInJoyFastWebBottomSocialView.b);
          ReadInJoyFastWebBottomSocialView.b(this.a, false);
          localQQToast.a();
        }
        else
        {
          ReadInJoyFastWebBottomSocialView.c(this.a, true);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleFavoriteStatus, isSuccess = " + paramBoolean1 + ", rowKey =  " + paramString + ", isFavorite = " + paramBoolean2 + ", cidList = " + paramArrayList);
    if ((paramBoolean1) && (ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID.equals(paramString)))
    {
      ReadInJoyFastWebBottomSocialView.a(this.a).put(paramString, paramArrayList);
      ReadInJoyFastWebBottomSocialView.b(this.a, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szw
 * JD-Core Version:    0.7.0.1
 */