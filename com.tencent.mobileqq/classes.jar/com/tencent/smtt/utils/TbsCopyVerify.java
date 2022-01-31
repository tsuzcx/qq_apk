package com.tencent.smtt.utils;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TbsCopyVerify
{
  private static final String TAG = "TbsCopyVerify";
  private TbsCopyVerify.FileInfoSet mReferenceFileSet = null;
  private TbsCopyVerify.FileInfoSet mVerifyFileSet = null;
  
  private boolean equal(TbsCopyVerify.FileInfoSet paramFileInfoSet1, TbsCopyVerify.FileInfoSet paramFileInfoSet2)
  {
    if ((paramFileInfoSet1 != null) && (paramFileInfoSet1.get() != null) && (paramFileInfoSet2 != null) && (paramFileInfoSet2.get() != null))
    {
      Object localObject1 = paramFileInfoSet1.get();
      paramFileInfoSet1 = paramFileInfoSet2.get();
      paramFileInfoSet2 = ((Map)localObject1).entrySet().iterator();
      while (paramFileInfoSet2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramFileInfoSet2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (TbsCopyVerify.FileInfo)((Map.Entry)localObject2).getValue();
        if (paramFileInfoSet1.containsKey(localObject1))
        {
          localObject1 = (TbsCopyVerify.FileInfo)paramFileInfoSet1.get(localObject1);
          if ((((TbsCopyVerify.FileInfo)localObject2).getFileSize() != ((TbsCopyVerify.FileInfo)localObject1).getFileSize()) || (((TbsCopyVerify.FileInfo)localObject2).getLastModify() != ((TbsCopyVerify.FileInfo)localObject1).getLastModify())) {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void generateReferenceValue(File paramFile)
  {
    this.mReferenceFileSet = new TbsCopyVerify.FileInfoSet(this, paramFile);
  }
  
  public void generateVerifyValue(File paramFile)
  {
    this.mVerifyFileSet = new TbsCopyVerify.FileInfoSet(this, paramFile);
  }
  
  public boolean verify()
  {
    if ((this.mVerifyFileSet == null) || (this.mReferenceFileSet == null)) {}
    while ((this.mVerifyFileSet.get().size() != this.mReferenceFileSet.get().size()) || (!equal(this.mReferenceFileSet, this.mVerifyFileSet))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCopyVerify
 * JD-Core Version:    0.7.0.1
 */