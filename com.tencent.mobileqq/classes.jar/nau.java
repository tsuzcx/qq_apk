import com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class nau
  extends atib
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public nau(QRecentC2CAVFileListContentView paramQRecentC2CAVFileListContentView) {}
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.i();
    this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.h();
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a(paramList);
    }
    int i;
    if (!paramBoolean2)
    {
      paramList = this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a.getFileTransferHandler();
      i = this.jdField_b_of_type_Int + 1;
      this.jdField_b_of_type_Int = i;
      paramList.a(i * 30, 30, QRecentC2CAVFileListContentView.a(this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView), 3);
    }
    do
    {
      return;
      paramList = new StringBuilder().append("finish recv querying, use ");
      i = this.jdField_b_of_type_Int + 1;
      this.jdField_b_of_type_Int = i;
      QLog.d("QRecentC2CAVFileListContentView", 2, i + " times");
      this.jdField_b_of_type_Boolean = true;
    } while (!this.jdField_a_of_type_Boolean);
    b();
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a(paramList);
    }
    int i;
    if (!paramBoolean2)
    {
      paramList = this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView.a.getFileTransferHandler();
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      paramList.b(i * 30, 30, QRecentC2CAVFileListContentView.a(this.jdField_a_of_type_ComTencentAvWtogetherViewQRecentC2CAVFileListContentView), 3);
    }
    do
    {
      return;
      paramList = new StringBuilder().append("finish send querying, use ");
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      QLog.d("QRecentC2CAVFileListContentView", 2, i + " times");
      this.jdField_a_of_type_Boolean = true;
    } while (!this.jdField_b_of_type_Boolean);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nau
 * JD-Core Version:    0.7.0.1
 */