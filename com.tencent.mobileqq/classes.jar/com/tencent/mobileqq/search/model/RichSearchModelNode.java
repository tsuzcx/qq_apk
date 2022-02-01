package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;

public class RichSearchModelNode
  extends NetSearchTemplateBaseItem
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int d;
  private String j;
  
  public RichSearchModelNode(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    try
    {
      this.d = new JSONObject(this.jdField_a_of_type_JavaLangString).getInt("appid");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(c, 2, "parseLayoutExtensions exception:" + paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.j = paramString;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.j;
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.RichSearchModelNode
 * JD-Core Version:    0.7.0.1
 */