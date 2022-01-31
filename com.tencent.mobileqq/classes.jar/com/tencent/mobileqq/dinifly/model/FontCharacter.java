package com.tencent.mobileqq.dinifly.model;

import android.support.annotation.RestrictTo;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import java.util.List;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class FontCharacter
{
  private final char character;
  private final String fontFamily;
  private final List<ShapeGroup> shapes;
  private final double size;
  private final String style;
  private final double width;
  
  public FontCharacter(List<ShapeGroup> paramList, char paramChar, double paramDouble1, double paramDouble2, String paramString1, String paramString2)
  {
    this.shapes = paramList;
    this.character = paramChar;
    this.size = paramDouble1;
    this.width = paramDouble2;
    this.style = paramString1;
    this.fontFamily = paramString2;
  }
  
  public static int hashFor(char paramChar, String paramString1, String paramString2)
  {
    return ((paramChar + '\000') * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public List<ShapeGroup> getShapes()
  {
    return this.shapes;
  }
  
  double getSize()
  {
    return this.size;
  }
  
  String getStyle()
  {
    return this.style;
  }
  
  public double getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return hashFor(this.character, this.fontFamily, this.style);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.FontCharacter
 * JD-Core Version:    0.7.0.1
 */