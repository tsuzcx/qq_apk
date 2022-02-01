package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

public class ParseException
  extends Exception
{
  public int curline = 0;
  
  public ParseException(String paramString, Exception paramException, int paramInt)
  {
    super(paramString, paramException);
    this.curline = paramInt;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.getMessage());
    localStringBuilder.append(" line: ");
    localStringBuilder.append(this.curline);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ParseException{message = ");
    localStringBuilder.append(getMessage());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.ParseException
 * JD-Core Version:    0.7.0.1
 */