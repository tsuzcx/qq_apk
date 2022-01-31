import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class jzb
  implements Runnable
{
  public jzb(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    int k = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = 0;
    Object localObject1;
    if (i < this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject1 != null) && (((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        ((QavListItemBase.ItemInfo)localObject1).b = false;
        ((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
        j = i;
        if (i >= k)
        {
          j = i;
          if (i <= m)
          {
            localObject1 = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - k);
            j = i;
            if ((localObject1 instanceof QavListItemBase))
            {
              j = i;
              if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_ComTencentWidgetHorizontalListView.a().equals(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter))
              {
                localObject1 = (QavListItemBase)localObject1;
                if (!this.jdField_a_of_type_Boolean) {
                  break label243;
                }
                j = 1000;
                label170:
                ((QavListItemBase)localObject1).a(j);
              }
            }
          }
        }
      }
    }
    for (int j = i;; j = -1)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.c == j)
        {
          localObject1 = localObject2;
          if (j != -1) {
            localObject1 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.get(j);
          }
        }
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a((QavListItemBase.ItemInfo)localObject1);
        }
      }
      return;
      label243:
      j = -1;
      break label170;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzb
 * JD-Core Version:    0.7.0.1
 */