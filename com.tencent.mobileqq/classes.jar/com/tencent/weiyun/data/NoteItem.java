package com.tencent.weiyun.data;

public class NoteItem
  extends CNativeObject
{
  public static final int TYPE_ALL = 0;
  public static final int TYPE_ARTICLE = 1;
  public static final int TYPE_COLLECTION = 4;
  public static final int TYPE_HTML_TEXT = 2;
  public static final int TYPE_MAIL = 3;
  public NoteItem.ArticleText articleText;
  public long createTime;
  public NoteItem.HtmlText htmlText;
  public boolean isDeleted = false;
  public String md5;
  public long modifyTime;
  private String noteId;
  public String noteSummary;
  public String noteTitle;
  public int noteType;
  public boolean starFlag;
  public long starTime;
  public String thumbUrl;
  
  private NoteItem()
  {
    super(0L);
  }
  
  private NoteItem(long paramLong)
  {
    super(paramLong);
  }
  
  public static NoteItem newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    NoteItem localNoteItem = new NoteItem(paramLong);
    localNoteItem.noteId = CBundleReader.getString(paramLong, "note_id");
    localNoteItem.noteType = CBundleReader.getInt(paramLong, "note_type", 0);
    localNoteItem.noteTitle = CBundleReader.getString(paramLong, "note_title");
    localNoteItem.noteSummary = CBundleReader.getString(paramLong, "note_summary");
    localNoteItem.createTime = CBundleReader.getLong(paramLong, "create_time", 0L);
    localNoteItem.modifyTime = CBundleReader.getLong(paramLong, "modify_time", 0L);
    localNoteItem.thumbUrl = CBundleReader.getString(paramLong, "thumb_url");
    localNoteItem.md5 = CBundleReader.getHexString(paramLong, "md5").toLowerCase();
    localNoteItem.starTime = CBundleReader.getLong(paramLong, "star_time", 0L);
    localNoteItem.starFlag = CBundleReader.getBoolean(paramLong, "star_flag", false);
    localNoteItem.isDeleted = CBundleReader.getBoolean(paramLong, "is_deleted", false);
    long l = CBundleReader.getLong(paramLong, "article_text", 0L);
    if (l != 0L) {
      localNoteItem.articleText = NoteItem.ArticleText.newInstance(l);
    }
    paramLong = CBundleReader.getLong(paramLong, "html_text", 0L);
    if (paramLong != 0L) {
      localNoteItem.htmlText = NoteItem.HtmlText.newInstance(paramLong);
    }
    localNoteItem.releaseNative();
    return localNoteItem;
  }
  
  public String noteId()
  {
    return this.noteId;
  }
  
  public void releaseNative()
  {
    if (isNative())
    {
      if (this.articleText != null) {
        this.articleText.releaseNative();
      }
      if (this.htmlText != null) {
        this.htmlText.releaseNative();
      }
    }
    super.releaseNative();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.data.NoteItem
 * JD-Core Version:    0.7.0.1
 */