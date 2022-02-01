package com.tencent.weiyun.data;

public class NoteItem$ArticleText
  extends CNativeObject
{
  public NoteItem.HtmlText articleComment;
  public String articleContent;
  public String articlePicsUrl;
  public String articleRawUrl;
  public String articleThumbId;
  public String articleTitle;
  public String articleUrl;
  
  private NoteItem$ArticleText()
  {
    super(0L);
  }
  
  private NoteItem$ArticleText(long paramLong)
  {
    super(paramLong);
  }
  
  public static ArticleText newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    ArticleText localArticleText = new ArticleText(paramLong);
    localArticleText.articleRawUrl = CBundleReader.getString(paramLong, "article_raw_url");
    localArticleText.articleTitle = CBundleReader.getString(paramLong, "article_title");
    localArticleText.articleUrl = CBundleReader.getString(paramLong, "article_url");
    localArticleText.articlePicsUrl = CBundleReader.getString(paramLong, "article_pics_url");
    localArticleText.articleThumbId = CBundleReader.getString(paramLong, "article_thumb_id");
    localArticleText.articleContent = CBundleReader.getString(paramLong, "article_content");
    paramLong = CBundleReader.getLong(paramLong, "article_comment", 0L);
    if (paramLong != 0L) {
      localArticleText.articleComment = NoteItem.HtmlText.newInstance(paramLong);
    }
    localArticleText.releaseNative();
    return localArticleText;
  }
  
  public void releaseNative()
  {
    if (isNative())
    {
      NoteItem.HtmlText localHtmlText = this.articleComment;
      if (localHtmlText != null) {
        localHtmlText.releaseNative();
      }
    }
    super.releaseNative();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.data.NoteItem.ArticleText
 * JD-Core Version:    0.7.0.1
 */