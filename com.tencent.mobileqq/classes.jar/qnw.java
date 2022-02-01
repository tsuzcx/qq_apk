import android.content.Context;
import android.view.View;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;

@Deprecated
public class qnw
{
  private PTSLiteItemViewManager a;
  
  public qnw(Context paramContext)
  {
    this.a = new PTSLiteItemViewManager(paramContext);
  }
  
  public View a(View paramView, PTSItemData paramPTSItemData)
  {
    Object localObject = paramView;
    if (this.a != null) {
      localObject = this.a.getView(paramView, paramPTSItemData);
    }
    return localObject;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void a(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (this.a != null) {
      this.a.setLiteEventListener(paramIPTSLiteEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnw
 * JD-Core Version:    0.7.0.1
 */