import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class tdj
  extends tdm
{
  public static final String a;
  public static final String b;
  public static final String c;
  private final int[] a;
  private int c;
  private String k;
  private String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + skt.a(2131633886);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
  }
  
  public tdj(QQUserUIItem paramQQUserUIItem)
  {
    this.k = paramQQUserUIItem.qq;
    this.i = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.jdField_c_of_type_Int = i;
      this.l = paramQQUserUIItem.uid;
      this.d = (paramQQUserUIItem.nickName + ajjy.a(2131639964) + sfm.jdField_a_of_type_JavaLangString);
      this.f = ("[" + sfm.jdField_a_of_type_JavaLangString + ajjy.a(2131639967) + paramQQUserUIItem.nickName + ajjy.a(2131639970) + sfm.jdField_a_of_type_JavaLangString);
      this.g = (paramQQUserUIItem.nickName + ajjy.a(2131639969) + sfm.jdField_a_of_type_JavaLangString + ajjy.a(2131639963) + sfm.jdField_a_of_type_JavaLangString + ajjy.a(2131639966) + skt.a(2131633883) + ajjy.a(2131639965));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.e = "0个小视频";; this.e = (paramQQUserUIItem.videoCount + ajjy.a(2131639968)))
    {
      this.j = ("#" + sfm.jdField_a_of_type_JavaLangString + "# " + this.d + "（" + this.e + "）");
      this.jdField_a_of_type_Int = 102;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 13, 14, 15, 16, 17, 18 };
      return;
      i = 0;
      break;
    }
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(b, new Object[] { this.k, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
    }
    return String.format(jdField_c_of_type_JavaLangString, new Object[] { this.k, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
  }
  
  protected void a(tet paramtet)
  {
    super.a(paramtet);
    if ((paramtet != null) && ((paramtet instanceof teu))) {
      ((teu)paramtet).jdField_a_of_type_JavaLangString = (tfe.b(this.i) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdj
 * JD-Core Version:    0.7.0.1
 */