import android.content.Context;
import android.view.View;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;

public class pvs
{
  private PTSLiteItemViewManager jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager;
  private final boolean jdField_a_of_type_Boolean = true;
  
  public pvs(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager = new PTSLiteItemViewManager(paramContext);
  }
  
  public View a(View paramView, PTSItemData paramPTSItemData)
  {
    Object localObject = paramView;
    if (this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager != null) {
      localObject = this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager.getView(paramView, paramPTSItemData);
    }
    return localObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager != null) {
      this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager.destroy();
    }
  }
  
  public void a(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager != null) {
      this.jdField_a_of_type_ComTencentPtsCoreLitePTSLiteItemViewManager.setLiteEventListener(paramIPTSLiteEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvs
 * JD-Core Version:    0.7.0.1
 */