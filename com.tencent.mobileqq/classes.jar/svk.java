import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.fpsreport.FPSXListView;

class svk
  implements Runnable
{
  svk(svj paramsvj, String paramString, Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Svj.a.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_Svj.a.a.getChildCount();
        int i = 0;
        if (i < j)
        {
          localObject = this.jdField_a_of_type_Svj.a.a.getChildAt(i);
          LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
          if ((localCornerListItemHolder == null) || (localCornerListItemHolder.a == null) || (localCornerListItemHolder.a.a == null) || (!this.jdField_a_of_type_JavaLangString.equals(localCornerListItemHolder.a.a.strPkgName))) {}
          for (;;)
          {
            i += 1;
            break;
            localObject = (ImageView)((View)localObject).findViewById(2131364307);
            if ((localObject != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
              ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
        }
      } while (this.jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Svj.a.a.findViewWithTag(this.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (!(localObject instanceof ImageView)) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null));
    ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */