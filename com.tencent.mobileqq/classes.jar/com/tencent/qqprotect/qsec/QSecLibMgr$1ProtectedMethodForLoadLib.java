package com.tencent.qqprotect.qsec;

import com.tencent.qqprotect.singleupdate.VerifyFileUtil;
import java.io.File;

final class QSecLibMgr$1ProtectedMethodForLoadLib
  implements CrashProtector.IProtectedMethod
{
  public QSecLibMgr.LoadedLibInfo a;
  
  QSecLibMgr$1ProtectedMethodForLoadLib(QSecLibMgr paramQSecLibMgr) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_b_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_b_of_type_JavaLangString.contains("..")))
    {
      Object localObject = new File(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_b_of_type_JavaLangString);
      if (!((File)localObject).exists())
      {
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.d = 12;
        return;
      }
      this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_a_of_type_ComTencentQqprotectQsecRundownProtection = new RundownProtection();
      int i;
      if ((this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_b_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_b_of_type_Int != 1)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 1) && (!VerifyFileUtil.a((File)localObject, null)))
      {
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.d = 10;
        return;
      }
      localObject = new Object[1];
      QSecLibMgr.LoadedLibInfo localLoadedLibInfo = this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo;
      localLoadedLibInfo.d = QSecFramework.a(2L, localLoadedLibInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.jdField_b_of_type_JavaLangString, null, null, (Object[])localObject);
      if ((localObject[0] != null) && ((localObject[0] instanceof Integer))) {
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.f = ((Integer)localObject[0]).intValue();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.d = 15;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr$LoadedLibInfo.d = 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.1ProtectedMethodForLoadLib
 * JD-Core Version:    0.7.0.1
 */