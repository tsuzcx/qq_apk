import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.util.HashMap;
import java.util.Map;

public class oqa
{
  private static int b = 5000;
  private int jdField_a_of_type_Int = 3;
  private final DownloadInfo jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private oqa(DownloadInfo paramDownloadInfo)
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.c);
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.e);
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.b));
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.h);
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, String.valueOf("qqNumber"));
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.n);
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.f);
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.i));
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.jdField_d_of_type_Boolean));
    this.jdField_a_of_type_JavaUtilMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.jdField_d_of_type_Long));
  }
  
  private Map<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int -= 1;
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DownloadInfo a()
  {
    return this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqa
 * JD-Core Version:    0.7.0.1
 */