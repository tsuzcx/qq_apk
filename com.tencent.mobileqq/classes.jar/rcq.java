import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class rcq
  extends ozf
{
  public rcq(ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, new Object[] { "handleDoFavoriteResult, isSuccess = ", Boolean.valueOf(paramBoolean), ", rowKey = ", paramString1, ", operationType = ", Integer.valueOf(paramInt), ", cid = ", paramString2 });
    if ((ReadInJoyFastWebBottomSocialViewNew.a(this.a) == null) || (ReadInJoyFastWebBottomSocialViewNew.a(this.a) == null))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleDoFavoriteResult but articleInfo is null.");
      return;
    }
    bcql localbcql;
    if ((paramBoolean) && (ReadInJoyFastWebBottomSocialViewNew.a(this.a).innerUniqueID.equals(paramString1)))
    {
      localbcql = new bcql(ReadInJoyFastWebBottomSocialViewNew.a(this.a));
      localbcql.d(2000);
      localbcql.b(2);
      localbcql.a(bcql.a(2));
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleDoFavoriteResult,operationType=" + paramInt + ",button status:" + ReadInJoyFastWebBottomSocialViewNew.a(this.a));
      if (paramInt != 1) {
        break label294;
      }
      ArrayList localArrayList = (ArrayList)ReadInJoyFastWebBottomSocialViewNew.a(this.a).get(ReadInJoyFastWebBottomSocialViewNew.a(this.a).innerUniqueID);
      paramString1 = localArrayList;
      if (localArrayList == null) {
        paramString1 = new ArrayList();
      }
      paramString1.add(paramString2);
      ReadInJoyFastWebBottomSocialViewNew.a(this.a).put(ReadInJoyFastWebBottomSocialViewNew.a(this.a).innerUniqueID, paramString1);
      if (ReadInJoyFastWebBottomSocialViewNew.a(this.a))
      {
        localbcql.a(ReadInJoyFastWebBottomSocialViewNew.a);
        localbcql.a();
      }
    }
    for (;;)
    {
      ReadInJoyFastWebBottomSocialViewNew.a(this.a, false);
      return;
      label294:
      if (paramInt == 2)
      {
        ReadInJoyFastWebBottomSocialViewNew.a(this.a).remove(ReadInJoyFastWebBottomSocialViewNew.a(this.a).innerUniqueID);
        if (!ReadInJoyFastWebBottomSocialViewNew.a(this.a))
        {
          localbcql.a(ReadInJoyFastWebBottomSocialViewNew.b);
          localbcql.a();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "handleFavoriteStatus, isSuccess = " + paramBoolean1 + ", rowKey =  " + paramString + ", isFavorite = " + paramBoolean2 + ", cidList = " + paramArrayList);
    if ((paramBoolean1) && (ReadInJoyFastWebBottomSocialViewNew.a(this.a).innerUniqueID.equals(paramString))) {
      ReadInJoyFastWebBottomSocialViewNew.a(this.a).put(paramString, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcq
 * JD-Core Version:    0.7.0.1
 */