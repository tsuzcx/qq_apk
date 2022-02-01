package com.tencent.viola.utils;

import android.support.annotation.NonNull;
import com.tencent.viola.core.ViolaEnvironment;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FunctionParser<K, V>
{
  public static final char SPACE = ' ';
  private static final String TAG = "FunctionParser";
  private FunctionParser.Lexer lexer;
  private FunctionParser.Mapper<K, V> mapper;
  
  public FunctionParser(@NonNull String paramString, @NonNull FunctionParser.Mapper<K, V> paramMapper)
  {
    this.lexer = new FunctionParser.Lexer(paramString, null);
    this.mapper = paramMapper;
  }
  
  private LinkedHashMap<K, V> definition()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    do
    {
      localLinkedHashMap.putAll(function());
    } while (FunctionParser.Lexer.access$200(this.lexer) == FunctionParser.Token.FUNC_NAME);
    return localLinkedHashMap;
  }
  
  private Map<K, V> function()
  {
    LinkedList localLinkedList = new LinkedList();
    String str = match(FunctionParser.Token.FUNC_NAME);
    match(FunctionParser.Token.LEFT_PARENT);
    localLinkedList.add(match(FunctionParser.Token.PARAM_VALUE));
    while (FunctionParser.Lexer.access$200(this.lexer) == FunctionParser.Token.COMMA)
    {
      match(FunctionParser.Token.COMMA);
      localLinkedList.add(match(FunctionParser.Token.PARAM_VALUE));
    }
    match(FunctionParser.Token.RIGHT_PARENT);
    return this.mapper.map(str, localLinkedList);
  }
  
  private String match(FunctionParser.Token paramToken)
  {
    if (paramToken == FunctionParser.Lexer.access$200(this.lexer))
    {
      paramToken = FunctionParser.Lexer.access$300(this.lexer);
      FunctionParser.Lexer.access$100(this.lexer);
      return paramToken;
    }
    if (!ViolaEnvironment.isDebugable())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramToken);
      localStringBuilder.append(": Token doesn't match");
      localStringBuilder.append(FunctionParser.Lexer.access$400(this.lexer));
      ViolaLogUtils.e("FunctionParser", localStringBuilder.toString());
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramToken);
    localStringBuilder.append("Token doesn't match");
    localStringBuilder.append(FunctionParser.Lexer.access$400(this.lexer));
    throw new FunctionParser.WXInterpretationException(localStringBuilder.toString(), null);
  }
  
  public LinkedHashMap<K, V> parse()
  {
    FunctionParser.Lexer.access$100(this.lexer);
    return definition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.FunctionParser
 * JD-Core Version:    0.7.0.1
 */