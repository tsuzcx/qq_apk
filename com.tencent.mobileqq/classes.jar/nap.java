import com.tencent.av.wtogether.view.QBaseFileListContentView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

public class nap
  implements Comparator<FileManagerEntity>
{
  public nap(QBaseFileListContentView paramQBaseFileListContentView) {}
  
  public int a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (paramFileManagerEntity2.srvTime > paramFileManagerEntity1.srvTime) {
      return 1;
    }
    if (paramFileManagerEntity2.srvTime < paramFileManagerEntity1.srvTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nap
 * JD-Core Version:    0.7.0.1
 */