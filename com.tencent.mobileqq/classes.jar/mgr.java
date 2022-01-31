import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class mgr
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  public mgr(ReadInJoyAllInOneBar paramReadInJoyAllInOneBar) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAllInOneBar.a, 2, "onGetCommentCount, isSucc = " + paramBoolean + ", commentCount = " + paramLong + ", retCode = " + paramInt);
    }
    if (paramBoolean) {
      this.a.a(paramLong);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (!ReadInJoyAllInOneBar.a(this.a).equals(paramString1)) {
      return;
    }
    ReadInJoyAllInOneBar.b(this.a, false);
    if (paramBoolean)
    {
      paramString1 = this.a;
      if (paramInt == 1) {
        bool1 = true;
      }
      paramString1.setFavorite(bool1);
      if (paramInt == 1)
      {
        ArrayList localArrayList = (ArrayList)ReadInJoyAllInOneBar.a(this.a).get(ReadInJoyAllInOneBar.a(this.a));
        paramString1 = localArrayList;
        if (localArrayList == null) {
          paramString1 = new ArrayList();
        }
        paramString1.add(paramString2);
        ReadInJoyAllInOneBar.a(this.a).put(ReadInJoyAllInOneBar.a(this.a), paramString1);
      }
      for (;;)
      {
        ReadInJoyAtlasManager.a().a(this.a.getContext(), paramBoolean, paramInt);
        return;
        if (paramInt == 2) {
          ReadInJoyAllInOneBar.a(this.a).remove(ReadInJoyAllInOneBar.a(this.a));
        }
      }
    }
    paramString1 = this.a;
    if (paramInt != 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramString1.setFavorite(bool1);
      break;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAllInOneBar.a, 2, "handleFavoriteStatus, isSucc = " + paramBoolean1 + "rowkey " + paramString + ", isFavorite = " + paramBoolean2 + ", cidList=" + paramArrayList);
    }
    if ((paramBoolean1) && (ReadInJoyAllInOneBar.a(this.a).equals(paramString)))
    {
      ReadInJoyAllInOneBar.a(this.a).put(ReadInJoyAllInOneBar.a(this.a), paramArrayList);
      this.a.b.setSelected(paramBoolean2);
      ReadInJoyAllInOneBar.a(this.a, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgr
 * JD-Core Version:    0.7.0.1
 */