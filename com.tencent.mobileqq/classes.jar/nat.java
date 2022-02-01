import com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import java.util.Comparator;

public class nat
  implements Comparator<OfflineFileInfo>
{
  public nat(QRecentC2CAVFileListContentView paramQRecentC2CAVFileListContentView) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    return Long.valueOf(paramOfflineFileInfo1.c).compareTo(Long.valueOf(paramOfflineFileInfo2.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nat
 * JD-Core Version:    0.7.0.1
 */