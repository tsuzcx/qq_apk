package com.tencent.mobileqq.writetogether.data;

import java.util.Comparator;
import java.util.Map;

class EditorModel$1
  implements Comparator<String>
{
  EditorModel$1(EditorModel paramEditorModel) {}
  
  public int a(String paramString1, String paramString2)
  {
    paramString1 = (Long)EditorModel.a(this.a).get(paramString1);
    paramString2 = (Long)EditorModel.a(this.a).get(paramString2);
    if (paramString1 == null) {
      return 1;
    }
    if (paramString2 == null) {
      return -1;
    }
    return (int)(paramString2.longValue() - paramString1.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.EditorModel.1
 * JD-Core Version:    0.7.0.1
 */