package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorDataRichTitleElement
{
  public String text;
  public int type;
  public String url;
  
  public QQLiveAnchorDataRichTitleElement() {}
  
  public QQLiveAnchorDataRichTitleElement(QQLiveAnchorDataRichTitleElement paramQQLiveAnchorDataRichTitleElement)
  {
    if (paramQQLiveAnchorDataRichTitleElement == null) {
      return;
    }
    this.type = paramQQLiveAnchorDataRichTitleElement.type;
    this.text = paramQQLiveAnchorDataRichTitleElement.text;
    this.url = paramQQLiveAnchorDataRichTitleElement.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRichTitleElement
 * JD-Core Version:    0.7.0.1
 */