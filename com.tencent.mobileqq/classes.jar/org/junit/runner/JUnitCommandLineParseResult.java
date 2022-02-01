package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runners.model.InitializationError;

class JUnitCommandLineParseResult
{
  private final List<Class<?>> classes = new ArrayList();
  private final List<String> filterSpecs = new ArrayList();
  private final List<Throwable> parserErrors = new ArrayList();
  
  private Request applyFilterSpecs(Request paramRequest)
  {
    try
    {
      Iterator localIterator = this.filterSpecs.iterator();
      while (localIterator.hasNext()) {
        paramRequest = paramRequest.filterWith(FilterFactories.createFilterFromFilterSpec(paramRequest, (String)localIterator.next()));
      }
      return paramRequest;
    }
    catch (FilterFactory.FilterNotCreatedException paramRequest) {}
    return errorReport(paramRequest);
  }
  
  private String[] copyArray(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 != paramInt2)
    {
      localArrayList.add(paramArrayOfString[paramInt1]);
      paramInt1 += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private Request errorReport(Throwable paramThrowable)
  {
    return Request.errorReport(JUnitCommandLineParseResult.class, paramThrowable);
  }
  
  public static JUnitCommandLineParseResult parse(String[] paramArrayOfString)
  {
    JUnitCommandLineParseResult localJUnitCommandLineParseResult = new JUnitCommandLineParseResult();
    localJUnitCommandLineParseResult.parseArgs(paramArrayOfString);
    return localJUnitCommandLineParseResult;
  }
  
  private void parseArgs(String[] paramArrayOfString)
  {
    parseParameters(parseOptions(paramArrayOfString));
  }
  
  public Request createRequest(Computer paramComputer)
  {
    if (this.parserErrors.isEmpty())
    {
      List localList = this.classes;
      return applyFilterSpecs(Request.classes(paramComputer, (Class[])localList.toArray(new Class[localList.size()])));
    }
    return errorReport(new InitializationError(this.parserErrors));
  }
  
  public List<Class<?>> getClasses()
  {
    return Collections.unmodifiableList(this.classes);
  }
  
  public List<String> getFilterSpecs()
  {
    return Collections.unmodifiableList(this.filterSpecs);
  }
  
  String[] parseOptions(String... paramVarArgs)
  {
    int i = 0;
    while (i != paramVarArgs.length)
    {
      String str = paramVarArgs[i];
      if (str.equals("--")) {
        return copyArray(paramVarArgs, i + 1, paramVarArgs.length);
      }
      if (str.startsWith("--"))
      {
        Object localObject;
        if ((!str.startsWith("--filter=")) && (!str.equals("--filter")))
        {
          localObject = this.parserErrors;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("JUnit knows nothing about the ");
          localStringBuilder.append(str);
          localStringBuilder.append(" option");
          ((List)localObject).add(new JUnitCommandLineParseResult.CommandLineParserError(localStringBuilder.toString()));
        }
        else
        {
          if (str.equals("--filter"))
          {
            i += 1;
            if (i < paramVarArgs.length)
            {
              str = paramVarArgs[i];
            }
            else
            {
              paramVarArgs = this.parserErrors;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(" value not specified");
              paramVarArgs.add(new JUnitCommandLineParseResult.CommandLineParserError(((StringBuilder)localObject).toString()));
              break;
            }
          }
          else
          {
            str = str.substring(str.indexOf('=') + 1);
          }
          this.filterSpecs.add(str);
        }
        i += 1;
      }
      else
      {
        return copyArray(paramVarArgs, i, paramVarArgs.length);
      }
    }
    return new String[0];
  }
  
  void parseParameters(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      try
      {
        this.classes.add(Classes.getClass(str));
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        List localList = this.parserErrors;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not find class [");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        localList.add(new IllegalArgumentException(localStringBuilder.toString(), localClassNotFoundException));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runner.JUnitCommandLineParseResult
 * JD-Core Version:    0.7.0.1
 */