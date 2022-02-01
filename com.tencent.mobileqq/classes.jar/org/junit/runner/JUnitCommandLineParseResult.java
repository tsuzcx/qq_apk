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
    if (this.parserErrors.isEmpty()) {
      return applyFilterSpecs(Request.classes(paramComputer, (Class[])this.classes.toArray(new Class[this.classes.size()])));
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
    String str;
    if (i != paramVarArgs.length)
    {
      str = paramVarArgs[i];
      if (str.equals("--")) {
        return copyArray(paramVarArgs, i + 1, paramVarArgs.length);
      }
      if (!str.startsWith("--")) {
        break label201;
      }
      if ((!str.startsWith("--filter=")) && (!str.equals("--filter"))) {
        break label157;
      }
      if (!str.equals("--filter")) {
        break label141;
      }
      i += 1;
      if (i < paramVarArgs.length)
      {
        str = paramVarArgs[i];
        label82:
        this.filterSpecs.add(str);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      this.parserErrors.add(new JUnitCommandLineParseResult.CommandLineParserError(str + " value not specified"));
      return new String[0];
      label141:
      str = str.substring(str.indexOf('=') + 1);
      break label82;
      label157:
      this.parserErrors.add(new JUnitCommandLineParseResult.CommandLineParserError("JUnit knows nothing about the " + str + " option"));
    }
    label201:
    return copyArray(paramVarArgs, i, paramVarArgs.length);
  }
  
  void parseParameters(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        try
        {
          this.classes.add(Classes.getClass(str));
          i += 1;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          for (;;)
          {
            this.parserErrors.add(new IllegalArgumentException("Could not find class [" + str + "]", localClassNotFoundException));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runner.JUnitCommandLineParseResult
 * JD-Core Version:    0.7.0.1
 */