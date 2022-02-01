package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.List;

public class ChatFileEntitySearchResultModel
  extends FileEntitySearchResultModel
{
  public CharSequence a()
  {
    Object localObject = (FileManagerEntity)this.a.get(0);
    String str1 = QfileTimeUtils.b(((FileManagerEntity)localObject).srvTime);
    String str2 = FileManagerUtil.b((FileManagerEntity)localObject);
    localObject = FileUtil.a(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append("  ");
    localStringBuilder.append(str1);
    localStringBuilder.append("  ");
    localStringBuilder.append((String)localObject);
    this.b = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileEntitySearchResultModel
 * JD-Core Version:    0.7.0.1
 */