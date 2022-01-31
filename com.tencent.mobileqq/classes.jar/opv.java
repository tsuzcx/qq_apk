import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyTabDragAnimationView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;

public class opv
{
  private static boolean a;
  
  public static View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate(BaseApplicationImpl.sApplication, 2131562687, null);
    ((DragTextView)localView.findViewById(2131379223)).setDragViewType(2);
    ((ReadInjoyTabDragAnimationView)localView.findViewById(2131377323)).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131378966)).setText(paramInt5);
    return localView;
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opv
 * JD-Core Version:    0.7.0.1
 */