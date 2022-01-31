import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class mlc
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  public mlc(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    FastWebActivity.a(this.a, false);
    QLog.d(FastWebActivity.a(this.a), 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if (FastWebActivity.a(this.a) == null) {
      QLog.d(FastWebActivity.a(this.a), 1, "handleDoFavoriteResult but articleInfo is null.");
    }
    QQToast localQQToast;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!FastWebActivity.a(this.a).innerUniqueID.equals(paramString1)));
      localQQToast = new QQToast(this.a.getBaseContext());
      localQQToast.d(2000);
      localQQToast.b(2);
      localQQToast.a(QQToast.a(2));
      if (paramInt == 1)
      {
        ArrayList localArrayList = (ArrayList)FastWebActivity.a(this.a).get(FastWebActivity.a(this.a).innerUniqueID);
        paramString1 = localArrayList;
        if (localArrayList == null) {
          paramString1 = new ArrayList();
        }
        paramString1.add(paramString2);
        FastWebActivity.a(this.a).put(FastWebActivity.a(this.a).innerUniqueID, paramString1);
        localQQToast.a("已收藏");
        if (FastWebActivity.b(this.a).isSelected())
        {
          FastWebActivity.a(this.a, true);
          localQQToast.a();
          QLog.d(FastWebActivity.a(this.a), 1, "handleDoFavoriteResult, add favorite succeed and update status.");
          return;
        }
        QLog.d(FastWebActivity.a(this.a), 1, "The favorite button status is not right, user delete favorite when waiting for request.");
        FastWebActivity.b(this.a, false);
        return;
      }
    } while (paramInt != 2);
    FastWebActivity.a(this.a).remove(FastWebActivity.a(this.a).innerUniqueID);
    localQQToast.a("已取消收藏");
    if (!FastWebActivity.b(this.a).isSelected())
    {
      FastWebActivity.a(this.a, false);
      localQQToast.a();
      QLog.d(FastWebActivity.a(this.a), 1, "handleDoFavoriteResult, delete favorite succeed and update status.");
      return;
    }
    QLog.d(FastWebActivity.a(this.a), 1, "The favorite button status is not right, user add favorite when waiting for request.");
    FastWebActivity.b(this.a, true);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastWebActivity.a(this.a), 2, "handleFavoriteStatus, isSuccess = " + paramBoolean1 + ", rowKey =  " + paramString + ", isFavorite = " + paramBoolean2 + ", cidList = " + paramArrayList);
    }
    if ((paramBoolean1) && (FastWebActivity.a(this.a).innerUniqueID.equals(paramString)))
    {
      FastWebActivity.a(this.a).put(paramString, paramArrayList);
      FastWebActivity.a(this.a, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlc
 * JD-Core Version:    0.7.0.1
 */