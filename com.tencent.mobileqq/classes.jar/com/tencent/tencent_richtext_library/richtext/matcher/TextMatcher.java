package com.tencent.tencent_richtext_library.richtext.matcher;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TextMatcher
{
  private int jdField_a_of_type_Int;
  protected String a;
  private Matcher jdField_a_of_type_JavaUtilRegexMatcher;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString;
  
  protected TextMatcher(Pattern paramPattern)
  {
    this.jdField_a_of_type_JavaUtilRegexPattern = paramPattern;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilRegexMatcher.find();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilRegexMatcher.start();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence);
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilRegexMatcher = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    a();
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      Matcher localMatcher = this.jdField_a_of_type_JavaUtilRegexMatcher;
      if (localMatcher == null) {
        return false;
      }
      int i = this.jdField_b_of_type_Int;
      if (i <= paramInt)
      {
        if (!this.jdField_a_of_type_Boolean) {
          return false;
        }
        if (i == paramInt)
        {
          this.jdField_a_of_type_JavaLangString = localMatcher.group();
          this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilRegexMatcher.end();
          a();
          return true;
        }
        a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.richtext.matcher.TextMatcher
 * JD-Core Version:    0.7.0.1
 */