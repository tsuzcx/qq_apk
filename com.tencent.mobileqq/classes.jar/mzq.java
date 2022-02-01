import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mzq
{
  private static mzq jdField_a_of_type_Mzq;
  private final HashMap<String, mzs> jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
  
  public static mzq a()
  {
    if (jdField_a_of_type_Mzq == null) {}
    try
    {
      if (jdField_a_of_type_Mzq == null) {
        jdField_a_of_type_Mzq = new mzq();
      }
      return jdField_a_of_type_Mzq;
    }
    finally {}
  }
  
  public ChooseFileInfo a(int paramInt, String paramString)
  {
    paramString = paramInt + "_" + paramString;
    paramString = (mzs)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo;
    }
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = paramInt + "_" + paramString;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ChooseFileAssistant", 4, "endOfStartWatchTogether, uinType[" + paramInt + "], uin[" + paramString + "]");
    }
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo)
  {
    Object localObject = paramInt + "_" + paramString;
    localObject = (mzs)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject != null) {
      ((mzs)localObject).jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ChooseFileAssistant", 4, "onChooseFile, uinType[" + paramInt + "], uin[" + paramString + "], file[" + paramChooseFileInfo + "]");
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.curType + "_" + paramSessionInfo.curFriendUin;
    mzs localmzs = new mzs(null);
    localmzs.jdField_a_of_type_Int = paramSessionInfo.curType;
    localmzs.jdField_a_of_type_JavaLangString = paramSessionInfo.curFriendUin;
    localmzs.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
    localmzs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, localmzs);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.ChooseFileAssistant", 4, "onClickQavWatchTogether, chat[" + paramSessionInfo + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzq
 * JD-Core Version:    0.7.0.1
 */