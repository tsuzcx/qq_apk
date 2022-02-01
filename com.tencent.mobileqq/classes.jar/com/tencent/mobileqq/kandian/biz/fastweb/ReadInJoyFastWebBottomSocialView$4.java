package com.tencent.mobileqq.kandian.biz.fastweb;

import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class ReadInJoyFastWebBottomSocialView$4
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  ReadInJoyFastWebBottomSocialView$4(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if ((ReadInJoyFastWebBottomSocialView.a(this.a) != null) && (ReadInJoyFastWebBottomSocialView.a(this.a) != null))
    {
      if ((paramBoolean) && (ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID.equals(paramString1)))
      {
        QQToast localQQToast = new QQToast(ReadInJoyFastWebBottomSocialView.a(this.a));
        localQQToast.d(2000);
        localQQToast.b(2);
        localQQToast.a(QQToast.a(2));
        paramString1 = new StringBuilder();
        paramString1.append("handleDoFavoriteResult,operationType=");
        paramString1.append(paramInt);
        paramString1.append(",button status:");
        paramString1.append(ReadInJoyFastWebBottomSocialView.b(this.a).isSelected());
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, paramString1.toString());
        if (paramInt == 1)
        {
          ArrayList localArrayList = (ArrayList)ReadInJoyFastWebBottomSocialView.a(this.a).get(ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID);
          paramString1 = localArrayList;
          if (localArrayList == null) {
            paramString1 = new ArrayList();
          }
          paramString1.add(paramString2);
          ReadInJoyFastWebBottomSocialView.a(this.a).put(ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID, paramString1);
          if (ReadInJoyFastWebBottomSocialView.b(this.a).isSelected())
          {
            localQQToast.a(ReadInJoyFastWebBottomSocialView.a);
            ReadInJoyFastWebBottomSocialView.b(this.a, true);
            localQQToast.a();
          }
          else
          {
            ReadInJoyFastWebBottomSocialView.c(this.a, false);
          }
        }
        else if (paramInt == 2)
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
      ReadInJoyFastWebBottomSocialView.a(this.a, false);
      return;
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "handleDoFavoriteResult but articleInfo is null.");
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFavoriteStatus, isSuccess = ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", rowKey =  ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isFavorite = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", cidList = ");
    localStringBuilder.append(paramArrayList);
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, localStringBuilder.toString());
    if ((paramBoolean1) && (ReadInJoyFastWebBottomSocialView.a(this.a).innerUniqueID.equals(paramString)))
    {
      ReadInJoyFastWebBottomSocialView.a(this.a).put(paramString, paramArrayList);
      ReadInJoyFastWebBottomSocialView.b(this.a, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView.4
 * JD-Core Version:    0.7.0.1
 */