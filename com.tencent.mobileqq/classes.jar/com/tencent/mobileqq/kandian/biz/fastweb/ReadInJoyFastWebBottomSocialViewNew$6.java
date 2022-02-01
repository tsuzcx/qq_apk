package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class ReadInJoyFastWebBottomSocialViewNew$6
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  ReadInJoyFastWebBottomSocialViewNew$6(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if ((ReadInJoyFastWebBottomSocialViewNew.b(this.a) != null) && (ReadInJoyFastWebBottomSocialViewNew.d(this.a) != null))
    {
      if ((paramBoolean) && (ReadInJoyFastWebBottomSocialViewNew.b(this.a).innerUniqueID.equals(paramString1)))
      {
        QQToast localQQToast = new QQToast(ReadInJoyFastWebBottomSocialViewNew.d(this.a));
        localQQToast.setDuration(2000);
        localQQToast.setType(2);
        localQQToast.setToastIcon(QQToast.getIconRes(2));
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleDoFavoriteResult,operationType=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(",button status:");
        ((StringBuilder)localObject).append(ReadInJoyFastWebBottomSocialViewNew.e(this.a));
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, ((StringBuilder)localObject).toString());
        if (paramInt == 1)
        {
          ArrayList localArrayList = (ArrayList)ReadInJoyFastWebBottomSocialViewNew.c(this.a).get(ReadInJoyFastWebBottomSocialViewNew.b(this.a).innerUniqueID);
          localObject = localArrayList;
          if (localArrayList == null) {
            localObject = new ArrayList();
          }
          ((ArrayList)localObject).add(paramString2);
          ReadInJoyFastWebBottomSocialViewNew.c(this.a).put(ReadInJoyFastWebBottomSocialViewNew.b(this.a).innerUniqueID, localObject);
          if (ReadInJoyFastWebBottomSocialViewNew.e(this.a))
          {
            localQQToast.setToastMsg(ReadInJoyFastWebBottomSocialViewNew.a);
            localQQToast.show();
          }
          ReadInJoyFastWebBottomSocialViewNew.a(this.a, paramBoolean, paramString1);
        }
        else if (paramInt == 2)
        {
          ReadInJoyFastWebBottomSocialViewNew.c(this.a).remove(ReadInJoyFastWebBottomSocialViewNew.b(this.a).innerUniqueID);
          if (!ReadInJoyFastWebBottomSocialViewNew.e(this.a))
          {
            localQQToast.setToastMsg(ReadInJoyFastWebBottomSocialViewNew.b);
            localQQToast.show();
          }
        }
      }
      ReadInJoyFastWebBottomSocialViewNew.a(this.a, false);
      return;
    }
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleDoFavoriteResult but articleInfo is null.");
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
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, localStringBuilder.toString());
    if ((paramBoolean1) && (ReadInJoyFastWebBottomSocialViewNew.b(this.a).innerUniqueID.equals(paramString))) {
      ReadInJoyFastWebBottomSocialViewNew.c(this.a).put(paramString, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew.6
 * JD-Core Version:    0.7.0.1
 */