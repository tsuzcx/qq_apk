import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

public class obx
  implements BusinessObserver
{
  public void a(vfz paramvfz) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, ArrayList<vgc> paramArrayList) {}
  
  public void a(boolean paramBoolean, vfz paramvfz, byte[] paramArrayOfByte, String paramString) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void c(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    default: 
      return;
    case 2: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        a(true, paramObject.getString("VALUE_ARTICLE_ID"), paramObject.getInt("VALUE_ARTICLE_LIKE_COUNT"));
        return;
      }
      a(false, null, 0);
      return;
    case 0: 
      if ((paramObject != null) && ((paramObject instanceof Bundle)))
      {
        a(paramBoolean, ((Bundle)paramObject).getString("VALUE_ARTICLE_ID"));
        return;
      }
      a(false, null);
      return;
    case 1: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        a(true, paramObject.getString("VALUE_ARTICLE_ID"), Boolean.valueOf(paramObject.getBoolean("VALUE_ARTICLE_IS_LIKED")).booleanValue());
        return;
      }
      a(false, null, false);
      return;
    case 4: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
      {
        paramObject = (Bundle)paramObject;
        if (paramObject.getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
        {
          b(true, paramObject.getInt("VALUE_ARTICLE_COMMENT_COUNT"));
          return;
        }
        b(false, 0);
        return;
      }
      b(false, 0);
      return;
    }
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      if (((Bundle)paramObject).getBoolean("VALUE_ARTICLE_IMAGEE_IS_SUCCESS", false))
      {
        a(true);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obx
 * JD-Core Version:    0.7.0.1
 */