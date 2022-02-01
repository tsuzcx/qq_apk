package org.junit.rules;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder
  extends ExternalResource
{
  private File folder;
  private final File parentFolder;
  
  public TemporaryFolder()
  {
    this(null);
  }
  
  public TemporaryFolder(File paramFile)
  {
    this.parentFolder = paramFile;
  }
  
  private File createTemporaryFolderIn(File paramFile)
  {
    paramFile = File.createTempFile("junit", "", paramFile);
    paramFile.delete();
    paramFile.mkdir();
    return paramFile;
  }
  
  private boolean isLastElementInArray(int paramInt, String[] paramArrayOfString)
  {
    return paramInt == paramArrayOfString.length - 1;
  }
  
  private void recursiveDelete(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        recursiveDelete(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private void validateFolderName(String paramString)
  {
    if (new File(paramString).getParent() == null) {
      return;
    }
    throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
  }
  
  protected void after()
  {
    delete();
  }
  
  protected void before()
  {
    create();
  }
  
  public void create()
  {
    this.folder = createTemporaryFolderIn(this.parentFolder);
  }
  
  public void delete()
  {
    File localFile = this.folder;
    if (localFile != null) {
      recursiveDelete(localFile);
    }
  }
  
  public File getRoot()
  {
    File localFile = this.folder;
    if (localFile != null) {
      return localFile;
    }
    throw new IllegalStateException("the temporary folder has not yet been created");
  }
  
  public File newFile()
  {
    return File.createTempFile("junit", null, getRoot());
  }
  
  public File newFile(String paramString)
  {
    Object localObject = new File(getRoot(), paramString);
    if (((File)localObject).createNewFile()) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("a file with the name '");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("' already exists in the test folder");
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public File newFolder()
  {
    return createTemporaryFolderIn(getRoot());
  }
  
  public File newFolder(String paramString)
  {
    return newFolder(new String[] { paramString });
  }
  
  public File newFolder(String... paramVarArgs)
  {
    File localFile = getRoot();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      String str = paramVarArgs[i];
      validateFolderName(str);
      localFile = new File(localFile, str);
      if ((!localFile.mkdir()) && (isLastElementInArray(i, paramVarArgs)))
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("a folder with the name '");
        paramVarArgs.append(str);
        paramVarArgs.append("' already exists");
        throw new IOException(paramVarArgs.toString());
      }
      i += 1;
    }
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.rules.TemporaryFolder
 * JD-Core Version:    0.7.0.1
 */