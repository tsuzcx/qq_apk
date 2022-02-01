package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorFansGroupItem
{
  private static final String GROUP_CARD_SCHEMA = "mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=group&source=external&uin={uin}&wSourceSubID=60003&authSig={authSig}";
  public String auth;
  public String groupCardSchema;
  public long groupId;
  public int isMember;
  public long memberNum;
  public String name;
  
  public static String fillGroupCardSchema(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("");
    localObject = "mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=group&source=external&uin={uin}&wSourceSubID=60003&authSig={authSig}".replace("{uin}", ((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    return ((String)localObject).replace("{authSig}", localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveAnchorFansGroupItem{groupId=");
    localStringBuilder.append(this.groupId);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", memberNum=");
    localStringBuilder.append(this.memberNum);
    localStringBuilder.append(", isMember=");
    localStringBuilder.append(this.isMember);
    localStringBuilder.append(", auth='");
    localStringBuilder.append(this.auth);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupCardSchema='");
    localStringBuilder.append(this.groupCardSchema);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem
 * JD-Core Version:    0.7.0.1
 */