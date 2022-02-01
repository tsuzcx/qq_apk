package com.tencent.mobileqq.filemanager.openbrowser;

import com.tencent.mobileqq.filebrowser.IFileBrowserParam;

public class FileBrowserParam
  implements IFileBrowserParam
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = null;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FileBrowserParam a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public FileBrowserParam a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam
 * JD-Core Version:    0.7.0.1
 */